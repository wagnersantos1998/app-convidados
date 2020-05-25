package com.example.convidados.view.viewHolder

import android.app.AlertDialog
import android.opengl.Visibility
import android.view.View
import android.widget.Button
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

        val btnDeletar = itemView.findViewById<Button>(R.id.btnDeletar)

        nome.setOnClickListener {
            listener.onClick(convidado.id)
        }

        presenca.setOnClickListener {
            listener.onClick(convidado.id)
        }
        nome.setOnLongClickListener {

            btnDeletar.visibility = View.VISIBLE

            true
        }

        presenca.setOnClickListener {

            btnDeletar.visibility = View.VISIBLE

            true
        }
        btnDeletar.setOnClickListener {
            AlertDialog.Builder(itemView.context).setTitle(R.string.remocao_convidado)
                .setMessage(R.string.deseja_remover)
                .setPositiveButton(R.string.remover) { dialog, which ->
                    listener.onDelete(convidado.id)
                }
                .setNeutralButton(R.string.cancelar, null).show()
        }
    }

}