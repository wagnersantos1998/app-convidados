package com.example.convidados.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.convidados.R
import com.example.convidados.service.constantes.ConvidadosConstantes
import com.example.convidados.view.adapter.ConvidadosAdapter
import com.example.convidados.view.listener.ConvidadoListener
import com.example.convidados.viewmodel.TodosConvidadosViewModel

class ConvidadosAusentesFragment : Fragment() {

    private lateinit var mViewModel: TodosConvidadosViewModel
    private val mAdapter: ConvidadosAdapter = ConvidadosAdapter()
    private lateinit var mListener: ConvidadoListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mViewModel =
            ViewModelProvider(this).get(TodosConvidadosViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_ausentes, container, false)

        val recycler = root.findViewById<RecyclerView>(R.id.recycler_ausentes)
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = mAdapter

        mListener = object : ConvidadoListener {
            override fun onClick(id: Int) {
                val intent = Intent(context, FormConvidados::class.java)
                val bundle = Bundle()
                bundle.putInt(ConvidadosConstantes.CONVIDADOID, id)
                intent.putExtras(bundle)
                startActivity(intent)

            }

            override fun onDelete(id: Int) {
                mViewModel.deletarConvidado(id)
                mViewModel.carregarListaConvidados(ConvidadosConstantes.FILTROS.AUSENTES)
            }
        }

        mAdapter.attachListener(mListener)
        observer()

        mViewModel.carregarListaConvidados(ConvidadosConstantes.FILTROS.AUSENTES)


        return root
    }

    override fun onResume() {
        super.onResume()
        mViewModel.carregarListaConvidados(ConvidadosConstantes.FILTROS.AUSENTES)
    }

    private fun observer() {
        mViewModel.convidadoLista.observe(viewLifecycleOwner, Observer {
            mAdapter.atualizarConvidados(it)
        })
    }

}
