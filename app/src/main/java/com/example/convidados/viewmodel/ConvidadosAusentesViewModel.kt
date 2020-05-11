package com.example.convidados.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ConvidadosAusentesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Tela de Convidados ausentes"
    }
    val text: LiveData<String> = _text
}