package com.example.compassouol.aplicacao.eventos.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

class EventoSelecionado {
    @Parcelize
    data class DadosDoEvento(
        val data: String,
        val descricao: String,
        val id: String,
        val urlImagem: String,
        val pessoas: List<String>,
        val preco: String,
        val titulo: String
    ): Parcelable

    companion object{
        lateinit var eventoSelecionado: DadosDoEvento
    }
}