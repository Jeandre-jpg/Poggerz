package com.example.poggerz.model


data class ChatChannel(val userIds: MutableList<String>) {
    constructor() : this(mutableListOf())
}