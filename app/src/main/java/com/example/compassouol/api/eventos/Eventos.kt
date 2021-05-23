package com.example.compassouol.api.eventos

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.text.NumberFormat
import java.util.*

class Eventos: ArrayList<Eventos.EventosItem>() {
    @Parcelize
    data class EventosItem(
        val date: Int,
        val description: String,
        val id: String,
        val image: String,
        val latitude: Double,
        val longitude: Double,
        val people: List<String>,
        val price: Double,
        val title: String
    ): Parcelable {
        fun precoformatado(): String {
            val format: NumberFormat = NumberFormat.getCurrencyInstance()
            val ptBr = Locale("pt", "BR")
            format.maximumFractionDigits = 2
            format.currency = Currency.getInstance(ptBr)
            return format.format(price)
        }

        fun dataFormatada(): String{
            val data = date.toString()
            return data.substring(0, 2) + "/" +
                    data.substring(2, 4)+ "/" +
                    data.substring(4, 8)
        }

        fun urlImagemFormatada(): String{
            return if(image.contains("https")) image
            else image.replace("http", "https")
        }
    }
}