package com.example.convidados.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.convidados.R
import com.example.convidados.service.model.ConvidadoModel
import com.example.convidados.view.listener.ConvidadoListener
import com.example.convidados.view.viewHolder.ConvidadosViewHolder


class ConvidadosAdapter : RecyclerView.Adapter<ConvidadosViewHolder>() {

    private var mConvidadosList: List<ConvidadoModel> = arrayListOf()
    private lateinit var mListener: ConvidadoListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConvidadosViewHolder {
        val item =
            LayoutInflater.from(parent.context).inflate(R.layout.row_convidados, parent, false)
        return ConvidadosViewHolder(item, mListener)
    }

    override fun getItemCount(): Int {
        return mConvidadosList.count()
    }

    override fun onBindViewHolder(holder: ConvidadosViewHolder, position: Int) {
        holder.bind(mConvidadosList[position])
    }

    fun atualizarConvidados(lista: List<ConvidadoModel>) {
        mConvidadosList = lista
        notifyDataSetChanged()
    }

    fun attachListener(listener: ConvidadoListener){
        mListener = listener
    }
}