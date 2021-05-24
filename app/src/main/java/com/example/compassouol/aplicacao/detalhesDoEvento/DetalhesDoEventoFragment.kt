package com.example.compassouol.aplicacao.detalhesDoEvento

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.compassouol.R
import com.example.compassouol.utils.mvvm.bases.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetalhesDoEventoFragment: BaseFragment() {
    private val viewModel: DetalhesDoEventoViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detalhes_do_evento_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        print("a")
    }

}