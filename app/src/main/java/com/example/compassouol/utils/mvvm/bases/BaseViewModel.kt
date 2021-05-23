package com.example.compassouol.utils.mvvm.bases

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compassouol.R
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

abstract class BaseViewModel: ViewModel() {
    protected lateinit var _job: Job

    val operacaoDialog: LiveData<Int> get() = _operacaoDialog
    protected val _operacaoDialog by lazy { MutableLiveData<Int>() }

    val mensagemDialog: LiveData<Int> get() = _mensagemDialog
    protected val _mensagemDialog by lazy { MutableLiveData<Int>() }

    val mensagemDeErro: LiveData<String> get() = _mensagemDeErro
    protected val _mensagemDeErro by lazy { MutableLiveData<String>() }

    val proximaTela: LiveData<Int> get() = _proximaTela
    protected val _proximaTela by lazy { MutableLiveData<Int>() }

    open fun limparFlags(){
        _proximaTela.value = R.string.limpar
        _operacaoDialog.value = R.string.limpar
        _mensagemDialog.value = R.string.dialog_remover
    }

    override fun onCleared() {
        super.onCleared()
        if(::_job.isInitialized) _job.cancel()
    }

    open fun onChamadaDeApiError(e: Throwable) {
        viewModelScope.launch {
            _operacaoDialog.value = R.string.dialog_remover
            _mensagemDeErro.value = e.message
        }
    }
}