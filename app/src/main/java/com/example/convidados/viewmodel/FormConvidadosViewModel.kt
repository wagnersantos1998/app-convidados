package com.example.convidados.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.convidados.service.model.ConvidadoModel
import com.example.convidados.service.repository.ConvidadoRepository

class FormConvidadosViewModel(application: Application) : AndroidViewModel(application) {

    private val mContext = application.applicationContext
    private val mConvidadoRepository: ConvidadoRepository =
        ConvidadoRepository.getInstance(mContext)

    private var mSaveGuest = MutableLiveData<Boolean>()
    val saveGuest: LiveData<Boolean> = mSaveGuest

    private var mConvidado = MutableLiveData<ConvidadoModel>()
    val convidado: LiveData<ConvidadoModel> = mConvidado

    fun salvar(id: Int, nome: String, presenca: Boolean) {

        val pessoa =
            ConvidadoModel(id, nome, presenca)

        if (id == 0) {
            mSaveGuest.value = mConvidadoRepository.salvarPessoa(pessoa)
        } else {
            mSaveGuest.value = mConvidadoRepository.atualizarPessoa(pessoa)
        }
    }

    fun load(id: Int) {
        mConvidado.value = mConvidadoRepository.listarUsuarioId(id)
    }

}
