package com.example.compassouol.aplicacao.detalhesDoEvento.view

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.compassouol.R
import com.example.compassouol.aplicacao.main.MainActivity
import com.example.compassouol.utils.mvvm.bases.BaseFragment
import kotlinx.android.synthetic.main.detalhes_do_evento_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetalhesDoEventoFragment: BaseFragment() {
    private val _viewModel: DetalhesDoEventoViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detalhes_do_evento_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        preencherDadosDoEvento()
        setupUi()
        subscribeUi()
    }

    private fun preencherDadosDoEvento(){
//        imageViewImagemDoEvento
        textViewTituloDoEvento.text = "Teste"
        textViewDataDoEvento.text = "00/00/0000"
        textViewValorDoEVento.text = "R$ 00,00"
        textViewDescricaoDoEVento.text = "Descrição"
    }

    private fun setupUi(){
        btnCompartilhar.setOnClickListener {
            val context = requireContext() as MainActivity
            val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("Link do Evento",
                "")
            clipboard.setPrimaryClip(clip)
            Toast.makeText(requireContext(),
                "Link do comprovante copiado com sucesso!",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun subscribeUi() {
        _viewModel.checkIn.observe(viewLifecycleOwner) {
            Toast.makeText(
                requireContext(),
                "Check-in realizado com sucesso!",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}