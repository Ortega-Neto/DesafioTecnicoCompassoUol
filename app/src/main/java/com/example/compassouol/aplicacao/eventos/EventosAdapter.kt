package com.example.compassouol.aplicacao.eventos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.compassouol.R
import com.example.compassouol.api.eventos.Eventos
import com.example.compassouol.databinding.RecyclerviewEventosBinding

class EventosAdapter(
    private val eventos: Eventos,
    private val listenerEventos: EventosRecyclerViewClickListener
): RecyclerView.Adapter<EventosAdapter.EventosViewHolder>() {

    inner class EventosViewHolder(
        val recyclerviewEventoBinding: RecyclerviewEventosBinding
    ): RecyclerView.ViewHolder(recyclerviewEventoBinding.root)

    override fun getItemCount() = eventos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = EventosViewHolder(
        DataBindingUtil.inflate<RecyclerviewEventosBinding>(
            LayoutInflater.from(parent.context),
            R.layout.recyclerview_eventos,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: EventosViewHolder, position: Int) {
        holder.recyclerviewEventoBinding.evento = eventos[position]

        holder.recyclerviewEventoBinding.root.setOnClickListener {
            listenerEventos.onEventosRecyclerViewItemClickListener(
                holder.recyclerviewEventoBinding.textViewNomeDoEvento,
                eventos[position]
            )
        }
    }
}