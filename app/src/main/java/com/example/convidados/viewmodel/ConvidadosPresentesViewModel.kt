package com.example.convidados.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ConvidadosPresentesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Tela de Convidados presentes no evento"
    }
    val text: LiveData<String> = _text
}