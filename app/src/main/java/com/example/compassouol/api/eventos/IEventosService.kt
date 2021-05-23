package com.example.compassouol.api.eventos

import retrofit2.Response

interface IEventosService {
    suspend fun buscarEventos(): Response<Eventos>
    suspend fun fazerCheckIn(participante: Participante): Response<Eventos>
}