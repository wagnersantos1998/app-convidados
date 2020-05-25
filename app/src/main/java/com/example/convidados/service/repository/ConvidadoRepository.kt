package com.example.convidados.service.repository

import android.content.ContentValues
import android.content.Context
import com.example.convidados.service.constantes.DataBaseConstantes
import com.example.convidados.service.model.ConvidadoModel

class ConvidadoRepository private constructor(context: Context) {

    private var mDatabase: Database = Database(context)

    companion object {
        private lateinit var repository: ConvidadoRepository

        fun getInstance(context: Context): ConvidadoRepository {
            if (!::repository.isInitialized) {
                repository = ConvidadoRepository(context)
            }
            return repository
        }
    }

    fun salvarPessoa(convidadoModel: ConvidadoModel): Boolean {
        return try {
            val db = mDatabase.writableDatabase

            val inserirValores = ContentValues()

            inserirValores.put(DataBaseConstantes.PESSOA.COLUNAS.NOME, convidadoModel.nome)
            inserirValores.put(DataBaseConstantes.PESSOA.COLUNAS.PRESENCA, convidadoModel.presenca)

            db.insert(DataBaseConstantes.PESSOA.TABLE_NAME, null, inserirValores)

            true
        } catch (e: Exception) {
            false
        }

    }

    fun atualizarPessoa(convidadoModel: ConvidadoModel): Boolean {
        return try {
            val db = mDatabase.writableDatabase

            val inserirValores = ContentValues()

            inserirValores.put(DataBaseConstantes.PESSOA.COLUNAS.NOME, convidadoModel.nome)
            inserirValores.put(DataBaseConstantes.PESSOA.COLUNAS.PRESENCA, convidadoModel.presenca)

            val selecao = DataBaseConstantes.PESSOA.COLUNAS.ID + " = ?"
            val args = arrayOf(convidadoModel.id.toString())

            db.update(DataBaseConstantes.PESSOA.TABLE_NAME, inserirValores, selecao, args)

            true
        } catch (e: Exception) {
            false
        }
    }

    fun deletarPessoa(id: Int): Boolean {
        return try {
            val db = mDatabase.writableDatabase

            val selecao = DataBaseConstantes.PESSOA.COLUNAS.ID + " = ?"
            val args = arrayOf(id.toString())

            db.delete(DataBaseConstantes.PESSOA.TABLE_NAME, selecao, args)

            true
        } catch (e: Exception) {
            false
        }
    }


    fun listarUsuarioId(id: Int): ConvidadoModel? {

        var convidado: ConvidadoModel? = null

        return try {

            val db = mDatabase.readableDatabase

            var projecao = arrayOf(
                DataBaseConstantes.PESSOA.COLUNAS.NOME,
                DataBaseConstantes.PESSOA.COLUNAS.PRESENCA
            )

            val selecao = DataBaseConstantes.PESSOA.COLUNAS.ID + " = ?"
            val args = arrayOf(id.toString())

            val cursor = db.query(
                DataBaseConstantes.PESSOA.TABLE_NAME,
                projecao,
                selecao,
                args,
                null,
                null,
                null
            )

            if (cursor != null && cursor.count > 0) {

                cursor.moveToFirst()

                val nome =
                    cursor.getString(cursor.getColumnIndex(DataBaseConstantes.PESSOA.COLUNAS.NOME))
                val presenca =
                    (cursor.getInt(cursor.getColumnIndex(DataBaseConstantes.PESSOA.COLUNAS.PRESENCA)) == 1)

                convidado = ConvidadoModel(id, nome, presenca)
            }
            cursor?.close()
            convidado
        } catch (e: Exception) {
            convidado
        }
    }

    fun listarTodasPessoa(): List<ConvidadoModel> {
        val list: MutableList<ConvidadoModel> = ArrayList()

        return try {
            val db = mDatabase.readableDatabase

            val projecao = arrayOf(
                DataBaseConstantes.PESSOA.COLUNAS.ID,
                DataBaseConstantes.PESSOA.COLUNAS.NOME, DataBaseConstantes.PESSOA.COLUNAS.PRESENCA
            )

            val cursor = db.query(
                DataBaseConstantes.PESSOA.TABLE_NAME,
                projecao,
                null,
                null,
                null,
                null,
                null
            )

            if (cursor != null && cursor.count > 0) {
                while (cursor.moveToNext()) {

                    val id =
                        cursor.getInt(cursor.getColumnIndex(DataBaseConstantes.PESSOA.COLUNAS.ID))
                    val nome =
                        cursor.getString(cursor.getColumnIndex(DataBaseConstantes.PESSOA.COLUNAS.NOME))
                    val presenca =
                        (cursor.getInt(cursor.getColumnIndex(DataBaseConstantes.PESSOA.COLUNAS.PRESENCA)) == 1)

                    val pessoa = ConvidadoModel(id, nome, presenca)

                    list.add(pessoa)
                }
            }

            cursor?.close()
            list

        } catch (e: Exception) {
            list
        }

    }

    fun listarPessoaPresente(): List<ConvidadoModel> {
        val list: MutableList<ConvidadoModel> = ArrayList()

        return try {
            val db = mDatabase.readableDatabase

            val projecao = arrayOf(
                DataBaseConstantes.PESSOA.COLUNAS.ID,
                DataBaseConstantes.PESSOA.COLUNAS.NOME,
                DataBaseConstantes.PESSOA.COLUNAS.PRESENCA
            )

            val condicao = DataBaseConstantes.PESSOA.COLUNAS.PRESENCA + " = 1"

            val cursor = db.query(
                DataBaseConstantes.PESSOA.TABLE_NAME,
                projecao,
                condicao,
                null,
                null,
                null,
                null
            )

            if (cursor != null && cursor.count > 0) {
                while (cursor.moveToNext()) {
                    val id =
                        cursor.getInt(cursor.getColumnIndex(DataBaseConstantes.PESSOA.COLUNAS.ID))
                    val nome =
                        cursor.getString(cursor.getColumnIndex(DataBaseConstantes.PESSOA.COLUNAS.NOME))
                    val presenca =
                        (cursor.getInt(cursor.getColumnIndex(DataBaseConstantes.PESSOA.COLUNAS.PRESENCA)) == 1)

                    val pessoa = ConvidadoModel(id, nome, presenca)
                    list.add(pessoa)
                }
            }
            cursor?.close()
            list
        } catch (e: Exception) {
            list
        }
    }

    fun listarPessoaAusente(): List<ConvidadoModel> {

        val list: MutableList<ConvidadoModel> = ArrayList()

        return try {
            val db = mDatabase.readableDatabase

            val projecao = arrayOf(
                DataBaseConstantes.PESSOA.COLUNAS.ID,
                DataBaseConstantes.PESSOA.COLUNAS.NOME,
                DataBaseConstantes.PESSOA.COLUNAS.PRESENCA
            )

            val condicao = DataBaseConstantes.PESSOA.COLUNAS.PRESENCA + " = 0"

            val cursor = db.query(
                DataBaseConstantes.PESSOA.TABLE_NAME,
                projecao,
                condicao,
                null,
                null,
                null,
                null
            )

            if (cursor != null && cursor.count > 0) {
                while (cursor.moveToNext()) {
                    val id =
                        cursor.getInt(cursor.getColumnIndex(DataBaseConstantes.PESSOA.COLUNAS.ID))
                    val nome =
                        cursor.getString(cursor.getColumnIndex(DataBaseConstantes.PESSOA.COLUNAS.NOME))
                    val presenca =
                        (cursor.getInt(cursor.getColumnIndex(DataBaseConstantes.PESSOA.COLUNAS.PRESENCA)) == 1)

                    val pessoa = ConvidadoModel(id, nome, presenca)
                    list.add(pessoa)
                }
            }
            cursor?.close()
            list
        } catch (e: Exception) {
            list
        }

    }
}