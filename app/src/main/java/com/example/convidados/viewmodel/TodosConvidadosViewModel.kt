package com.example.convidados.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.convidados.service.model.PessoaModel
import com.example.convidados.service.repository.PessoaRepository

class TodosConvidadosViewModel(application: Application) : AndroidViewModel(application) {

    private val mRepository = PessoaRepository.getInstance(application)

    private val mListaPessoa = MutableLiveData<List<PessoaModel>>()
    val pessoaLista: LiveData<List<PessoaModel>> = mListaPessoa

    fun carregarListaConvidados() {

        mListaPessoa.value = mRepository.listarTodasPessoa()
    }

}