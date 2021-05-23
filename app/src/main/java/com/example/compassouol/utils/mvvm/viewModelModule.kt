package com.example.compassouol.utils.mvvm

import com.example.compassouol.aplicacao.eventos.EventosViewModel
import com.example.compassouol.api.eventos.EventosService
import com.example.compassouol.api.eventos.IEventosService
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    single<IEventosService> {
        EventosService()
    }

    viewModel {
        EventosViewModel(
            eventosService = get()
        )
    }
}