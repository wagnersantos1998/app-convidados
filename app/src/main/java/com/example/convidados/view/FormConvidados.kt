package com.example.convidados.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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


        }

    }
}
