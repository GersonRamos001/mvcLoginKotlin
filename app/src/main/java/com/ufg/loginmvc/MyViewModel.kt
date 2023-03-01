package com.example.myviewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MyViewModel: ViewModel() {
    var username = ""
    var password = ""

    fun validateCredentials():Boolean{

        return username.equals("clave") && password.equals("clave")
    }


}