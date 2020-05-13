package com.example.convidados.service.repository

import android.content.Context
import com.example.convidados.service.model.PessoaModel

class PessoaRepository private constructor(context: Context){

    private var mDatabase: Database = Database(context)

    companion object {
        private lateinit var repository: PessoaRepository

        fun getInstance(context: Context) : PessoaRepository{
            if (!::repository.isInitialized){
                repository = PessoaRepository(context)
            }
            return repository
        }
    }

    fun salvarPessoa(pessoaModel: PessoaModel){
    }

    fun deletarPessoa(pessoaModel: PessoaModel){
    }

    fun atualizarPessoa(pessoaModel: PessoaModel){
    }

    fun listarTodasPessoa():List<PessoaModel>{
        val list: MutableList<PessoaModel> = ArrayList()
        return list
    }

    fun listarPessoaPresente():List<PessoaModel>{
        val list: MutableList<PessoaModel> = ArrayList()
        return list
    }

    fun listarPessoaAusente():List<PessoaModel>{
        val list: MutableList<PessoaModel> = ArrayList()
        return list
    }
}