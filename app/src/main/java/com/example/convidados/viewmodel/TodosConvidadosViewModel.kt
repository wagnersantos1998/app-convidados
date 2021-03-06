package com.example.convidados.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.convidados.service.constantes.ConvidadosConstantes
import com.example.convidados.service.model.ConvidadoModel
import com.example.convidados.service.repository.ConvidadoRepository

class TodosConvidadosViewModel(application: Application) : AndroidViewModel(application) {

    private val mRepository = ConvidadoRepository.getInstance(application)

    private val mListaPessoa = MutableLiveData<List<ConvidadoModel>>()
    val convidadoLista: LiveData<List<ConvidadoModel>> = mListaPessoa

    fun carregarListaConvidados(filtro: Int) {

        if (filtro == ConvidadosConstantes.FILTROS.TODOS) {

            mListaPessoa.value = mRepository.listarTodasPessoa()

        } else if (filtro == ConvidadosConstantes.FILTROS.PRESENTES) {
            mListaPessoa.value = mRepository.listarPessoaPresente()
        } else {
            mListaPessoa.value = mRepository.listarPessoaAusente()
        }

    }

    fun deletarConvidado(id: Int) {
        mRepository.deletarPessoa(id)
    }

}