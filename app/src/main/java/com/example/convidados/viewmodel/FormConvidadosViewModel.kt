package com.example.convidados.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.convidados.service.model.PessoaModel
import com.example.convidados.service.repository.PessoaRepository

class FormConvidadosViewModel : ViewModel() {

    private var mPessoaRepository: PessoaRepository =
        PessoaRepository()

    private var mSaveGuest = MutableLiveData<Boolean>()
    var saveGuest: LiveData<Boolean> = mSaveGuest

    fun salvar(nome: String, presenca: Boolean) {

        var pessoa =
            PessoaModel(nome, presenca)
        mPessoaRepository.salvarPessoa(pessoa)
    }

}
