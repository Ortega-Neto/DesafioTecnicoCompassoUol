package com.example.compassouol.aplicacao.detalhesDoEvento.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.compassouol.R
import com.example.compassouol.api.eventos.IEventosService
import com.example.compassouol.api.eventos.Participante
import com.example.compassouol.utils.api.ApiUtils
import com.example.compassouol.utils.mensagem.MensagemUtils
import com.example.compassouol.utils.mvvm.bases.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DetalhesDoEventoViewModel(
    private val eventosService: IEventosService
): BaseViewModel() {

    val checkIn: LiveData<Boolean> get() = _checkIn
    private val _checkIn = MutableLiveData<Boolean>()

    fun fazerCheckInNoEvento(participante: Participante){
        _mensagemDialog.value = R.string.realizar_chek_in
        _operacaoDialog.value = R.string.dialog_mostrar

        _job = ApiUtils.launchDataLoad(::onChamadaDeApiError) {
            val resposta = eventosService.fazerCheckIn(participante)
            if (resposta.isSuccessful) {
                withContext(Dispatchers.Main){
                    _operacaoDialog.value = R.string.dialog_remover
                    _checkIn.value = true
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