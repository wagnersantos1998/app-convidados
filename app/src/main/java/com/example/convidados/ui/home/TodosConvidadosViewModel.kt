package com.example.convidados.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TodosConvidadosViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Tela de todos os convidados"
    }
    val text: LiveData<String> = _text
}