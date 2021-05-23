package com.example.compassouol.utils.api.eventos

import retrofit2.Response

interface IEventosService {
    suspend fun buscarEventos(): Response<Eventos>
    suspend fun fazerCheckIn(participante: Participante): Response<Eventos>
}