package com.example.convidados.service.repository

import com.example.convidados.service.model.PessoaModel

class PessoaRepository {

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