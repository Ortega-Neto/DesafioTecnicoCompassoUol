package com.example.compassouol.aplicacao.eventos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.compassouol.R
import com.example.compassouol.api.eventos.Eventos
import com.example.compassouol.utils.mvvm.bases.BaseFragment
import kotlinx.android.synthetic.main.eventos_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class EventosFragment: BaseFragment(), EventosRecyclerViewClickListener {
    private val _viewModel: EventosViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.eventos_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupUi()
        subscribeUi()
        _viewModel.buscarEventos()
    }

    private fun setupUi(){
        btnBuscarEventos.setOnClickListener {
            erroAoBuscarEventos.visibility = View.GONE
            _viewModel.buscarEventos()
        }
    }

    private fun subscribeUi() {
        _viewModel.operacaoDialog.observe(viewLifecycleOwner) {
            opcoesDialog(_viewModel.operacaoDialog.value!!, _viewModel.mensagemDialog.value!!)
        }
        _viewModel.mensagemDeErro.observe(viewLifecycleOwner){
            erroAoBuscarEventos.visibility = View.VISIBLE
            exibirMensagemDeErro(it)
        }
        _viewModel.eventos.observe(viewLifecycleOwner, { produtos ->
            recyclerViewEventos.also{
                it.layoutManager = GridLayoutManager(requireContext(), 1)
                it.setHasFixedSize(true)
                it.adapter = EventosAdapter(produtos, this)
            }
        })
    }

    override fun onEventosRecyclerViewItemClickListener(view: View, evento: Eventos.EventosItem) {

    }
}