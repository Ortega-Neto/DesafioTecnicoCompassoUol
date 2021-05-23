package com.example.compassouol.aplicacao.eventos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.compassouol.R
import com.example.compassouol.api.eventos.Eventos
import com.example.compassouol.api.eventos.IEventosService
import com.example.compassouol.utils.api.ApiUtils
import com.example.compassouol.utils.mensagem.MensagemUtils
import com.example.compassouol.utils.mvvm.bases.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class EventosViewModel(
    private val eventosService: IEventosService
): BaseViewModel(){

    val eventos: LiveData<List<Eventos.EventosItem>> get() = _eventos
    private val _eventos = MutableLiveData<List<Eventos.EventosItem>>()

    fun buscarEventos(){
        _mensagemDialog.value = R.string.buscando_eventos
        _operacaoDialog.value = R.string.dialog_mostrar

        _job = ApiUtils.launchDataLoad(::onChamadaDeApiError) {
            val resposta = eventosService.buscarEventos()
            if (resposta.isSuccessful) {
                val eventos = resposta.body()
                withContext(Dispatchers.Main){
                    _operacaoDialog.value = R.string.dialog_remover
                    _eventos.value = eventos!!
                }
            }
            else{
                onChamadaDeApiError(
                    Exception(
                        MensagemUtils.mensagemDoCodigoDeErro(resposta.code()) + "\n${resposta.message()}"
                    )
                )
            }
        }
    }
}