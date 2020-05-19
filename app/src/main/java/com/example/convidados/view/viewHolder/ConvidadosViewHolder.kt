package com.example.convidados.view.viewHolder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.convidados.R
import com.example.convidados.service.model.PessoaModel

class ConvidadosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(pessoa: PessoaModel) {
        val nome = itemView.findViewById<TextView>(R.id.txtNome)
        nome.text = "Nome: ${pessoa.nome}"

        val presenca = itemView.findViewById<TextView>(R.id.txtPresenca)
        presenca.text = "Presença: ${pessoa.presenca}"
    }

}