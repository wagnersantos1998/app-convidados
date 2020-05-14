package com.example.convidados.service.repository

import android.content.ContentValues
import android.content.Context
import com.example.convidados.service.model.PessoaModel

class PessoaRepository private constructor(context: Context) {

    private var mDatabase: Database = Database(context)

    companion object {
        private lateinit var repository: PessoaRepository

        fun getInstance(context: Context): PessoaRepository {
            if (!::repository.isInitialized) {
                repository = PessoaRepository(context)
            }
            return repository
        }
    }

    fun salvarPessoa(pessoaModel: PessoaModel): Boolean {
        try {
            val db = mDatabase.writableDatabase

            val inserirValores = ContentValues()

            inserirValores.put(DataBaseConstants.PESSOA.COLUNAS.NOME, pessoaModel.name)
            inserirValores.put(DataBaseConstants.PESSOA.COLUNAS.PRESENCA, pessoaModel.presenca)

            db.insert(DataBaseConstants.PESSOA.TABLE_NAME, null, inserirValores)

            return true
        } catch (e: Exception) {
            return false
        }

    }

    fun deletarPessoa(pessoaModel: PessoaModel) {
    }

    fun atualizarPessoa(pessoaModel: PessoaModel) {
    }

    fun listarTodasPessoa(): List<PessoaModel> {
        val list: MutableList<PessoaModel> = ArrayList()
        return list
    }

    fun listarPessoaPresente(): List<PessoaModel> {
        val list: MutableList<PessoaModel> = ArrayList()
        return list
    }

    fun listarPessoaAusente(): List<PessoaModel> {
        val list: MutableList<PessoaModel> = ArrayList()
        return list
    }
}