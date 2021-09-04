package com.app.buna.sharingmarket.model.items.chat

data class ChatRoom(
    val lastMessage: String,
    val profileUri: String,
    val roomId: String,
    val destUserName: String,
    val destUserUid: String,
    val timeStamp: Long
)