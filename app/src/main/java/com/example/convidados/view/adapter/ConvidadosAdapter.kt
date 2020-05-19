package com.example.convidados.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.convidados.R
import com.example.convidados.service.model.PessoaModel
import com.example.convidados.view.viewHolder.ConvidadosViewHolder


class ConvidadosAdapter : RecyclerView.Adapter<ConvidadosViewHolder>() {

    private var mConvidadosList: List<PessoaModel> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConvidadosViewHolder {
        val item =
            LayoutInflater.from(parent.context).inflate(R.layout.row_convidados, parent, false)
        return ConvidadosViewHolder(item)
    }

    override fun getItemCount(): Int {
        return mConvidadosList.count()
    }

    override fun onBindViewHolder(holder: ConvidadosViewHolder, position: Int) {
        holder.bind(mConvidadosList[position])
    }

    fun atualizarConvidados(lista: List<PessoaModel>) {
        mConvidadosList = lista
        notifyDataSetChanged()
    }
}