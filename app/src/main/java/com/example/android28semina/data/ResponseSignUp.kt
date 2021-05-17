package com.example.android28semina.data

data class ResponseSignUp(
    val success:String,
    val message:String,
    val data:Data

){
    data class Data(
        val nickname:String
    )
}
