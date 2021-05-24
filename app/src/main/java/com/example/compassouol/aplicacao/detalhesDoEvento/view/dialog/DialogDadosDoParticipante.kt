package com.example.compassouol.aplicacao.detalhesDoEvento.view.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.compassouol.R
import com.example.compassouol.api.eventos.Participante
import kotlinx.android.synthetic.main.dialog_dados_do_participante.*

class DialogDadosDoParticipante(val idDoEvento: String): DialogFragment() {

    val dadosInseridos: LiveData<Participante> get() = _dadosInseridos
    private val _dadosInseridos = MutableLiveData<Participante>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog!!.window?.setBackgroundDrawableResource(R.drawable.round_corner)

        isCancelable = true

        return inflater.inflate(R.layout.dialog_dados_do_participante, container, false)
    }

    override fun onStart() {
        super.onStart()
        btnSalvarDados.setOnClickListener{
            if(verificarDados(
                    edtNome.text.toString(),
                    edtEmail.text.toString()
                )
            ) {
                _dadosInseridos.value = Participante(
                    idDoEvento,
                    edtNome.text.toString(),
                    edtEmail.text.toString()
                )
                dismiss()
            }
        }
    }

    private fun verificarDados(nome: String, email: String): Boolean{
        if(nome.isNullOrEmpty() || email.isNullOrEmpty() || !validadorDeEmail(email)){
            if(nome.isNullOrEmpty()) edtNome.error = getString(R.string.erro_campo_vazio)
            if(email.isNullOrEmpty()) edtEmail.error = getString(R.string.erro_campo_vazio)
            else edtEmail.error = getString(R.string.erro_email)
            return false
        }

        return true
    }

    private fun validadorDeEmail(email: String): Boolean{
        val emailRegex = "^[A-Za-z](.*)([@])(.+)(\\.)(.+)"
        return emailRegex.toRegex().matches(email);
    }
}