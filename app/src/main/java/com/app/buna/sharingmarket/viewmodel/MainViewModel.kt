package com.app.buna.sharingmarket.viewmodel

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.buna.sharingmarket.R
import com.app.buna.sharingmarket.activity.BoardActivity
import com.app.buna.sharingmarket.activity.InitialActivity
import com.app.buna.sharingmarket.callbacks.IFirebaseGetStorageDataCallback
import com.app.buna.sharingmarket.callbacks.ILogoutCallback
import com.app.buna.sharingmarket.model.items.CategoryItem
import com.app.buna.sharingmarket.model.items.ProductItem
import com.app.buna.sharingmarket.repository.FirebaseRepository
import com.app.buna.sharingmarket.repository.PreferenceUtil
import com.app.buna.sharingmarket.utils.NetworkStatus
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainViewModel(application: Application, val context: Context) :
    AndroidViewModel(application) {
    class Factory(val application: Application, val context: Context) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MainViewModel(application, context) as T
        }
    }

    val productItems = MutableLiveData<ArrayList<ProductItem>>(ArrayList())
    var surveyOptionId: Int? = null
    var surveyText: String? = null


    // View Model의 product
    fun getProductData(category: String, callback: IFirebaseGetStorageDataCallback) {
        FirebaseRepository.instance.getProductData(category, callback)
    }

    fun clickProduct(position: Int) {

        val intent = Intent(context, BoardActivity::class.java)
            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            .putExtra("product_item", productItems.value!!.get(position))
        context.startActivity(intent)
    }

    @SuppressLint("ResourceType")
    fun getCategoryList(): ArrayList<CategoryItem> {
        val list = ArrayList<CategoryItem>()
        val categoriesTitle = context.resources.getStringArray(R.array.category_title)
        val categoriesDrawables = context.resources.obtainTypedArray(R.array.category_res_id)

        for (i in categoriesTitle.indices) {
            list.add(CategoryItem(categoriesTitle[i], categoriesDrawables.getResourceId(i, 0)))
        }
        return list
    }

    fun getUserName(): String = PreferenceUtil.getString(context, "nickname")
    fun getJibun(): String = PreferenceUtil.getString(context, "jibun")

    // 로그아웃
    fun logout(logoutCallback: ILogoutCallback) {
        if (NetworkStatus.isConnectedInternet(context)) {
            Firebase.auth.signOut() // 로그아웃
            PreferenceUtil.putInt(context, "fragment_page", 0) // 현재까지 진행한 fragment_page를 초기화면으로 돌림
            logoutCallback.success()
            Log.d("MainViewModel", "Logout Success")
        }else {
            logoutCallback.fail()
            Log.d("MainViewModel", "Logout Fail")
        }
    }

    // 회원탈퇴
    fun unregister(cause: String, id: Int, activityFinishCallback: () -> Unit) {
        // DB에 탈퇴 사유 저장
        FirebaseRepository.instance.saveUnregisterCause(cause, id) { // DB에 저장을 완료하였다면
            Firebase.auth.currentUser!!.delete().addOnSuccessListener { task -> // 파이어베이스에서 유저 delete
                Log.d("MainViewModel", "User account deleted")
                PreferenceUtil.putInt(context, "fragment_page", 0) // 현재까지 진행한 fragment_page를 초기화면으로 돌림
                activityFinishCallback() // 액티비티 종료 콜백
            }.addOnFailureListener { exception ->
                print(exception.message)
            }
        }
    }
}