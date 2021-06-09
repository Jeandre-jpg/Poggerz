package com.example.poggerz.model

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Instant
import java.time.format.DateTimeFormatter

data class Chats(
    val message: String = "",
    val sender: String = "",
    val timestamp: String = ""

)