package com.example.android28semina

import android.app.Activity
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android28semina.api.ServiceCreator
import com.example.android28semina.data.RequestSignUp
import com.example.android28semina.data.ResponseSignUp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpViewModel : ViewModel() {


    val inputName = MutableLiveData("")
    val inputId = MutableLiveData("")
    val inputPassword = MutableLiveData("")

    val signUpComplete= MutableLiveData<Boolean>()

    fun signUpCheck(){
        if(inputId.value?.isBlank()==true || inputName.value?.isBlank()==true || inputPassword.value?.isBlank()==true){
            signUpComplete.value=false
        }
        else{
            requestSignUp()
        }
    }


    fun requestSignUp(){
        val signUpBody=  RequestSignUp(email= inputName.value!!,password = inputPassword.value!!,
            sex = "0",phone = "010-2060-6725",birth = "1999-08-17",nickname = inputId.value!!)

        val call: Call<ResponseSignUp> = ServiceCreator.soptService.postSignUp(signUpBody)

        call.enqueue(object :
            Callback<ResponseSignUp> {
            override fun onResponse(call: Call<ResponseSignUp>, response: Response<ResponseSignUp>) {
                if(response.isSuccessful){
                    Log.d("soptsignup","회원가입 성공")
                    signUpComplete.value=true
                }

            }

            override fun onFailure(call: Call<ResponseSignUp>, t: Throwable) {

            }
        })

    }
}