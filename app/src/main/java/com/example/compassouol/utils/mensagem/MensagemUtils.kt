package com.example.compassouol.utils.mensagem

import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MensagemUtils {
    companion object{
        val BADREQUEST = 400
        val NOTFOUND = 404
        val INTERNALSERVERERROR = 500

        fun mensagemDoCodigoDeErro(codigoDeErro: Int): String{
            return when(codigoDeErro){
                BADREQUEST -> "$codigoDeErro - Erro na requisição"
                NOTFOUND -> "$codigoDeErro - Não encontrado"
                INTERNALSERVERERROR -> "$codigoDeErro - Erro interno do Servidor"
                else -> "($codigoDeErro)"
            }
        }

        fun mostrarMenssagemDeErro(context: Context, mensagem: String){
            val mensagemVerificada = if(mensagem.contains("Unable to resolve host")){
                "Erro ao realizar conexão, verifique a sua internet"
            }
            else if(mensagem != ""){
                mensagem
            }
            else{
                ""
            }
            if(mensagemVerificada != "") {
                CoroutineScope(Dispatchers.Main).launch {
                    Toast.makeText(context, mensagemVerificada, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}