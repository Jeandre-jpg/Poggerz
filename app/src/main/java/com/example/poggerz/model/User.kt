package com.example.poggerz.model

class User (
    val id: String = "",
    val email: String = "",
    val name: String = "",
    val profileImagePath: String?
)
{
    constructor(): this("", "", "", null)
}
