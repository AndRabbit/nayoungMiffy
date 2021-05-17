package com.example.android28semina.data

data class ResponseLogin(
    val success:Boolean,
    val message: String,
    val data: LoginData
){
    data class LoginData(
        val userId:Int,
        val user_nickname:String,
        val token:String,
    )
}
