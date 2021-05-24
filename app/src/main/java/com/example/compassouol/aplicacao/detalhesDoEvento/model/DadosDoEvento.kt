package com.example.compassouol.aplicacao.detalhesDoEvento.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

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