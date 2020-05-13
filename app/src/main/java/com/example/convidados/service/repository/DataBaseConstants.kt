package com.example.convidados.service.repository

class DataBaseConstants private constructor() {

    object PESSOA {

        const val TABLE_NAME = "Pessoa"

        object COLUNAS {

            const val ID = "id"
            const val NOME = "nome"
            const val PRESENCA = "presenca"

        }
    }
}