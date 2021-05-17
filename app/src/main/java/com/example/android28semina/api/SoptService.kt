package com.example.android28semina.api

import com.example.android28semina.data.RequestLogin
import com.example.android28semina.data.RequestSignUp
import com.example.android28semina.data.ResponseLogin
import com.example.android28semina.data.ResponseSignUp
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SoptService {
    @POST("/login/signin")
        fun postLogin(
            @Body body: RequestLogin
        ):Call<ResponseLogin>

    @POST("/login/signup")
    fun postSignUp(
        @Body body: RequestSignUp
    ):Call<ResponseSignUp>

}