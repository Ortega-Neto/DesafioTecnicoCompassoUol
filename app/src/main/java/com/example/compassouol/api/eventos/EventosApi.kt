package com.example.compassouol.api.eventos

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface EventosApi {
    @GET("events")
    suspend fun buscarEventos() : Response<Eventos>

    @POST("checkin")
    suspend fun fazerCheckIn(@Body participante: Participante) : Response<RespostaCheckIn>
}