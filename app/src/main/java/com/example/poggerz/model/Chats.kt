package com.example.poggerz.model

import com.google.firebase.Timestamp
import com.google.type.DateTime
import java.time.LocalDateTime
import java.util.*

data class Chats(
    val message: String = "",
    val sender: String = "",
    var timestamp: Timestamp? = Timestamp.now()


    )

