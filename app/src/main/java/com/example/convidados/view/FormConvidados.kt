package com.example.convidados.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.convidados.viewmodel.FormConvidadosViewModel
import com.example.convidados.R
import kotlinx.android.synthetic.main.activity_form_convidados.*

class FormConvidados : AppCompatActivity() {

    private lateinit var mViewModel: FormConvidadosViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_convidados)

        mViewModel = ViewModelProvider(this).get(FormConvidadosViewModel::class.java)

        btnSalvar.setOnClickListener {
            var nome = edtNome.text.toString().toLowerCase()
            nome = nome.capitalize()
            validacao(nome)
        }
        observe()
    }

    private fun validacao(nome: String) {
        if (!nome.isNullOrBlank()) {
            if (rdPresente.isChecked) {

                var presente = rdPresente.isChecked

                mViewModel.salvar(nome, presente)
            } else if (rdAusente.isChecked) {

                var ausente = false

                mViewModel.salvar(nome, ausente)
            } else {
                Toast.makeText(
                    applicationContext,
                    "${nome}, Por favor informe a confirmacao de presença", Toast.LENGTH_SHORT
                ).show()
            }
        } else {
            Toast.makeText(
                applicationContext,
                "Por favor informe seu nome", Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun observe() {
        mViewModel.saveGuest.observe(this, Observer {
            if (it) {
                Toast.makeText(applicationContext, "sucesso", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext, "falha", Toast.LENGTH_SHORT).show()
            }
        })
    }

}
