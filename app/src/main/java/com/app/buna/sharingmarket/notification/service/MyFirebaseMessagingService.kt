package com.app.buna.sharingmarket.notification.service

import android.annotation.SuppressLint
import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import android.util.Log
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.app.buna.sharingmarket.R
import com.app.buna.sharingmarket.activity.MainActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.NotificationTarget
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    val CHANNEL_ID = "1000"
    val CHANNEL_DESCRIPTION = "푸시 알림을 전달받기 위한 채널입니다."

    override fun onNewToken(token: String) {
        super.onNewToken(token)
    }

    @SuppressLint("LongLogTag")
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        Log.d("MyFirebaseMessagingService", "message received")
        createNotificationChannel(getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager)
        sendNotification(remoteMessage)
    }

    private fun createNotificationChannel(notificationManager: NotificationManager) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // 2. NotificationChannel 객체 생성 (첫번째 인자 : 관리 id, 두번째 인자 : 사용자에게 보여줄 채널 이름)
            val channel =
                NotificationChannel(CHANNEL_ID, "push", NotificationManager.IMPORTANCE_HIGH)
            channel.enableVibration(true)
            channel.description = CHANNEL_DESCRIPTION

            // 3. 알림 메세지를 관리하는 객체에 노티피케이션 채널 등록
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun sendNotification(remoteMessage: RemoteMessage) {
        val title = remoteMessage.notification?.title // 닉네임
        val message = remoteMessage.notification?.body // 메세지 내용
        val profileUri = remoteMessage.notification?.imageUrl // 프로필 Url


        // 메세지 클릭시 앱으로 이동하기 위한 PendingIntent
        val pendingIntent = PendingIntent.getActivity(
            this,
            1000,
            Intent(this, MainActivity::class.java),
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        // 노티피케이션 빌더
        val notificationBuilder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setTicker(getString(R.string.push_ticker))
            .setSmallIcon(R.drawable.app_icon)
            .setDefaults(Notification.DEFAULT_SOUND or Notification.DEFAULT_VIBRATE or Notification.FLAG_AUTO_CANCEL)
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setWhen(System.currentTimeMillis())
            .setContentTitle(getString(R.string.app_name))
            .setContentText(getString(R.string.push_content))
            .setStyle(NotificationCompat.DecoratedCustomViewStyle())
            .setAutoCancel(true)

        // 커스텀 노티피케이션 레이아웃
        val customView = RemoteViews(packageName, R.layout.notification_layout).apply {
            setTextViewText(R.id.title_text_view, title) // 메세지 제목 (닉네임)
            setTextViewText(R.id.message_text_view, message) // 메세지 내용
            //setImageViewUri(R.id.notification_profile_image_view, profileUri) // 프로필 사진 설정
            notificationBuilder.setCustomContentView(this) // 노티피케이션 커스텀 뷰 Set
        }

        // 상대방이 프로필을 설정한 상대라면
        if (profileUri != null) {
            val notificationTarget = NotificationTarget(
                this,
                R.id.notification_profile_image_view,
                customView,
                notificationBuilder.build(),
                System.currentTimeMillis().toInt()
            )

            // 보낸 사람 프로필 이미지
            Glide.with(this).asBitmap().error(R.drawable.default_profile)
                .fallback(R.drawable.default_profile).load(profileUri).circleCrop()
                .into(notificationTarget)
        }

        // 푸시 발동
        NotificationManagerCompat.from(this).notify(1000, notificationBuilder.build())
    }
}