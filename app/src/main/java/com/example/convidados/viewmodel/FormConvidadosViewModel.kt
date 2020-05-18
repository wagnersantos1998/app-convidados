package com.example.convidados.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.convidados.service.model.PessoaModel
import com.example.convidados.service.repository.PessoaRepository

class FormConvidadosViewModel(application: Application) : AndroidViewModel(application) {

    private var mContext = application.applicationContext
    private var mPessoaRepository: PessoaRepository =
        PessoaRepository.getInstance(mContext)

    private var mSaveGuest = MutableLiveData<Boolean>()
    var saveGuest: LiveData<Boolean> = mSaveGuest

    fun salvar(nome: String, presenca: Boolean) {

        var pessoa =
            PessoaModel(nome = nome, presenca = presenca)

        mSaveGuest.value = mPessoaRepository.salvarPessoa(pessoa)
    }

}
