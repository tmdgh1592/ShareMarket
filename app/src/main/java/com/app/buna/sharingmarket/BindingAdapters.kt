package com.app.buna.sharingmarket

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.app.buna.sharingmarket.adapter.ProductRecyclerAdapter
import com.app.buna.sharingmarket.model.items.ProductItem
import com.facebook.login.widget.LoginButton
import com.google.android.gms.common.SignInButton

object BindingAdapters {

    // 구글 로그인 버튼
    @BindingAdapter("android:onClick")
    @JvmStatic
    fun bindSignInClick(button: SignInButton, method: () -> Unit) {
        button.setOnClickListener { method.invoke() }
    }

    // 하트 개수 텍스트뷰
    @BindingAdapter("android:heart_count")
    @JvmStatic
    fun bindSignInClick(textView: TextView, count: Int) {
        when (count) {
            0 -> textView.visibility = View.GONE // 개수가 0개면 안보이게 함
            else -> {
                textView.visibility = View.VISIBLE
                textView.setText(Integer.toString(count))
            }
        }
    }

    // 하트 이미지 뷰
    @BindingAdapter("android:heart_visible")
    @JvmStatic
    fun bindSignInClick(imageView: ImageView, count: Int) {
        when (count) {
            0 -> imageView.visibility = View.GONE // 개수가 0개면 안보이게 함
            else -> {
                imageView.visibility = View.VISIBLE
            }
        }
    }
}
