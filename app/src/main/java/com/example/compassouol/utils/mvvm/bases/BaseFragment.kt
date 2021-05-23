package com.example.compassouol.utils.mvvm.bases

import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.example.compassouol.R
import com.example.compassouol.utils.dialog.LoadingDialog
import com.example.compassouol.utils.mensagem.MensagemUtils.Companion.mostrarMenssagemDeErro

abstract class BaseFragment: Fragment() {
    private lateinit var _dialog: LoadingDialog

    fun opcoesDialog(@StringRes operacao: Int, @StringRes mensagem: Int) {
        when (getString(operacao)) {
            getString(R.string.dialog_mostrar) -> mostrarDialog(mensagem)
            getString(R.string.dialog_atualizar) -> atualizarTextoDialog(mensagem)
            getString(R.string.dialog_remover) -> removerDialog()
        }
    }

    fun mostrarDialog(@StringRes mensagem: Int) {
        _dialog = LoadingDialog(getString(mensagem), requireContext())
        _dialog.show()
    }

    fun atualizarTextoDialog(@StringRes mensagem: Int) {
        _dialog.setText(getString(mensagem))
    }

    fun removerDialog() {
        _dialog.dismiss()
    }

    fun exibirMensagemDeErro(mensagem: String) {
        mostrarMenssagemDeErro(requireContext(), mensagem)
    }
}