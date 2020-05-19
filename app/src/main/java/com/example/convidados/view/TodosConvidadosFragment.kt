package com.example.convidados.view

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
import com.example.convidados.view.adapter.ConvidadosAdapter
import com.example.convidados.viewmodel.TodosConvidadosViewModel

class TodosConvidadosFragment : Fragment() {

    private lateinit var todosConvidadosViewModel: TodosConvidadosViewModel
    private val mAdapter: ConvidadosAdapter = ConvidadosAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        todosConvidadosViewModel =
            ViewModelProvider(this).get(TodosConvidadosViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_todos, container, false)

        val recycler = root.findViewById<RecyclerView>(R.id.recycler_todos_convidados)
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = mAdapter

        observer()

        todosConvidadosViewModel.carregarListaConvidados()

        return root
    }

    private fun observer() {
        todosConvidadosViewModel.pessoaLista.observe(viewLifecycleOwner, Observer {
            mAdapter.atualizarConvidados(it)
        })
    }
}
