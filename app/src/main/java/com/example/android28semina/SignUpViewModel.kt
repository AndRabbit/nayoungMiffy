package com.example.android28semina

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpViewModel : ViewModel() {


    val inputName = MutableLiveData("")

    val inputId = MutableLiveData("")
    val inputPassword = MutableLiveData("")
}