package com.example.poggerz.model

import com.example.poggerz.model.MessageType.IMAGE
import com.google.firebase.messaging.Constants
import java.util.*


data class ImageMessage(val imagePath: String,
                        override val time: Date,
                        override val senderId: String,
                        override val recipientId: String,
                        override val senderName: String,
                        override val type: String = Constants.MessageType.IMAGE)
    : Message {
    constructor() : this("", Date(0), "", "", "")
}