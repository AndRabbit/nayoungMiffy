package com.example.android28semina

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignInViewModel : ViewModel() {

    //val inputEmail = MutableLiveData("")
    val inputPassword = MutableLiveData("")

    private val _inputEmail = MutableLiveData<String>()
    val inputEmail: LiveData<String> = _inputEmail


    fun requestCheckSignIn() {


    }


}