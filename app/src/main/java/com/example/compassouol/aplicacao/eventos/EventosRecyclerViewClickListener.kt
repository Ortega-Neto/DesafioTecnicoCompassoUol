package com.example.compassouol.aplicacao.eventos

import android.view.View
import com.example.compassouol.api.eventos.Eventos

interface EventosRecyclerViewClickListener {
    fun onProdutosRecyclerViewItemClickListener(view: View, evento: Eventos.EventosItem)
}