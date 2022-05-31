package com.example.basegrupo2.model.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class Fragment1VM : ViewModel() {
    val name = MutableLiveData<String>()

    lateinit var texto : String
    fun changeName(){
        // Se puede hacer de 2 formas:
        //name.postValue("trucha")
        name.value = "trucha"
    }


}