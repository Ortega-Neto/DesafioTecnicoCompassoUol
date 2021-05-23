package com.example.compassouol.utils.api.eventos

import java.text.NumberFormat
import java.util.*

data class Eventos(
    val eventosItem: EventosItem
){
    data class EventosItem(
        val date: Int,
        val description: String,
        val id: String,
        val image: String,
        val latitude: Double,
        val longitude: Double,
        val people: List<Any>,
        val price: Double,
        val title: String
    ){
        fun precoformatado(): String {
            val format: NumberFormat = NumberFormat.getCurrencyInstance()
            val ptBr = Locale("pt", "BR")
            format.maximumFractionDigits = 2
            format.currency = Currency.getInstance(ptBr)
            return format.format(price)
        }

        fun dataFormatada(): String{
            val data = date.toString()
            return data.substring(0, 2) +
                    data.substring(2, 4)+
                    data.substring(4)
        }
    }
}