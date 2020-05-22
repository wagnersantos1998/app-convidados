package com.example.convidados.service.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.convidados.service.constantes.DataBaseConstantes

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
            ("create table " + DataBaseConstantes.PESSOA.TABLE_NAME + " ("
                    + DataBaseConstantes.PESSOA.COLUNAS.ID + " integer primary key autoincrement, "
                    + DataBaseConstantes.PESSOA.COLUNAS.NOME + " text, "
                    + DataBaseConstantes.PESSOA.COLUNAS.PRESENCA + " integer);")
    }
}