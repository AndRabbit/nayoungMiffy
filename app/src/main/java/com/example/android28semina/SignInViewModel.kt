package com.example.android28semina

import android.app.Application
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android28semina.api.ServiceCreator
import com.example.android28semina.common.MySharedPreferences
import com.example.android28semina.data.RequestLogin
import com.example.android28semina.data.ResponseLogin
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Body

class SignInViewModel : ViewModel() {

    //val inputEmail = MutableLiveData("")
     val inputPassword = MutableLiveData<String>()
   // val inputPassword: LiveData<String> = _inputPassword

     val inputEmail = MutableLiveData<String>()
   // val inputEmail: LiveData<String> = _inputEmail

    val loginCheckValue = MutableLiveData<Boolean>()

    fun loginCheck(){
        if(inputEmail.value?.isBlank()==true || inputPassword.value?.isBlank()==true){
            loginCheckValue.value=false
        }else{
            requestCheckSignIn()
        }

    }


    fun requestCheckSignIn() {
        val loginBody=  RequestLogin(email= inputEmail.value!!,password = inputPassword.value!!)

        val call: Call<ResponseLogin> = ServiceCreator.soptService.postLogin(loginBody)

        call.enqueue(object :
            Callback<ResponseLogin> {
            override fun onResponse(call: Call<ResponseLogin>, response: Response<ResponseLogin>) {
                if(response.isSuccessful){
                    Log.d("soptlogin","로그인 성공")
                    loginCheckValue.value=true

                }

            }

            override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {

            }
        })





    }


}