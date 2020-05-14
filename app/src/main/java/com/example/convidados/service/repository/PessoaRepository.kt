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
        return try {
            val db = mDatabase.writableDatabase

            val inserirValores = ContentValues()

            inserirValores.put(DataBaseConstants.PESSOA.COLUNAS.NOME, pessoaModel.nome)
            inserirValores.put(DataBaseConstants.PESSOA.COLUNAS.PRESENCA, pessoaModel.presenca)

            db.insert(DataBaseConstants.PESSOA.TABLE_NAME, null, inserirValores)

            true
        } catch (e: Exception) {
            false
        }

    }

    fun atualizarPessoa(pessoaModel: PessoaModel): Boolean {
        return try {
            val db = mDatabase.writableDatabase

            val inserirValores = ContentValues()

            inserirValores.put(DataBaseConstants.PESSOA.COLUNAS.NOME, pessoaModel.nome)
            inserirValores.put(DataBaseConstants.PESSOA.COLUNAS.PRESENCA, pessoaModel.presenca)

            val selecao = DataBaseConstants.PESSOA.COLUNAS.ID + " = ?"
            val args = arrayOf(pessoaModel.id.toString())

            db.update(DataBaseConstants.PESSOA.TABLE_NAME, inserirValores, selecao, args)

            true
        } catch (e: Exception) {
            false
        }
    }

    fun deletarPessoa(pessoaModel: PessoaModel): Boolean {
        return try {
            val db = mDatabase.writableDatabase

            val selecao = DataBaseConstants.PESSOA.COLUNAS.ID + " = ?"
            val args = arrayOf(pessoaModel.id.toString())

            db.delete(DataBaseConstants.PESSOA.TABLE_NAME, selecao, args)

            true
        } catch (e: Exception) {
            false
        }
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