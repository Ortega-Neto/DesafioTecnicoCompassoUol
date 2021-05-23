package com.example.compassouol.aplicacao.eventos

import android.view.View
import com.example.compassouol.api.eventos.Eventos

interface EventosRecyclerViewClickListener {
    fun onEventosRecyclerViewItemClickListener(view: View, evento: Eventos.EventosItem)
}