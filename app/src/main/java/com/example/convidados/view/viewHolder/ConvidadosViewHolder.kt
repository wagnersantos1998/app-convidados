package com.example.convidados.view.viewHolder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.convidados.R
import com.example.convidados.service.model.ConvidadoModel
import com.example.convidados.view.listener.ConvidadoListener

class ConvidadosViewHolder(itemView: View, private val listener: ConvidadoListener) :
    RecyclerView.ViewHolder(itemView) {

    fun bind(convidado: ConvidadoModel) {
        val nome = itemView.findViewById<TextView>(R.id.txtNome)
        nome.text = "Nome: ${convidado.nome}"

        val presenca = itemView.findViewById<TextView>(R.id.txtPresenca)
        presenca.text = "Presença: ${convidado.presenca}"

        nome.setOnClickListener {
            listener.onClick(convidado.id)
        }

        presenca.setOnClickListener {
            listener.onClick(convidado.id)
        }

    }

}