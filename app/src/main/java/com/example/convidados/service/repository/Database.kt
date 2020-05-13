package com.example.convidados.service.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Database(context: Context) : SQLiteOpenHelper(context, NOME_BANCO, null, VERSAO) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

    }

    companion object {
        private const val NOME_BANCO = "convidados.db"
        private const val VERSAO = 1

        private const val CREATE_TABLE =
            ("create table" + DataBaseConstants.PESSOA.TABLE_NAME + " ("
                    + DataBaseConstants.PESSOA.COLUNAS.ID + "integer primary key autoincrement,"
                    + DataBaseConstants.PESSOA.COLUNAS.NOME + " text, "
                    + DataBaseConstants.PESSOA.COLUNAS.PRESENCA + "integer);")
    }
}