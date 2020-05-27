package com.example.convidados.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.convidados.R
import com.example.convidados.service.constantes.ConvidadosConstantes
import com.example.convidados.viewmodel.FormConvidadosViewModel
import kotlinx.android.synthetic.main.activity_form_convidados.*

class FormConvidados : AppCompatActivity() {

    private lateinit var mViewModel: FormConvidadosViewModel
    private var mConvidadoId: Int = 0

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
        loadData()

    }

    private fun loadData() {
        val bundle = intent.extras
        if (bundle != null) {
            mConvidadoId = bundle.getInt(ConvidadosConstantes.CONVIDADOID)

            mViewModel.load(mConvidadoId)
        }
    }

    private fun validacao(nome: String) {
        if (!nome.isNullOrBlank()) {
            if (rdPresente.isChecked) {

                var presente = rdPresente.isChecked

                mViewModel.salvar(mConvidadoId, nome, presente)
            } else if (rdAusente.isChecked) {

                var ausente = false

                mViewModel.salvar(mConvidadoId, nome, ausente)
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
        mViewModel.convidado.observe(this, Observer {
            edtNome.setText(it.nome)
            if (it.presenca) {
                rdPresente.isChecked = true
            } else {
                rdAusente.isChecked = true
            }
        })
    }

}
