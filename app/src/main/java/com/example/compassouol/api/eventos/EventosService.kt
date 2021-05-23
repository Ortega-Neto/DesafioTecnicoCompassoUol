package com.example.compassouol.api.eventos

import com.example.compassouol.utils.api.ApiUtils
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class EventosService: IEventosService {
    private val okHttp = OkHttpClient.Builder()
        .connectTimeout(60000, TimeUnit.MILLISECONDS)
        .callTimeout(60000, TimeUnit.MILLISECONDS)
        .writeTimeout(60000, TimeUnit.MILLISECONDS)
        .readTimeout(60000, TimeUnit.MILLISECONDS)

    private val api: EventosApi = Retrofit.Builder()
        .baseUrl(ApiUtils.baseURL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttp.build())
        .build()
        .create(EventosApi::class.java)

    override suspend fun buscarEventos(): Response<Eventos> =
        api.buscarEventos()

    override suspend fun fazerCheckIn(participante: Participante): Response<Eventos> =
        api.fazerCheckIn(participante = participante)
}
