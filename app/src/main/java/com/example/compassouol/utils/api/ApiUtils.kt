package com.example.compassouol.utils.api

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ApiUtils {
    companion object{
        val baseURL = "https://5f5a8f24d44d640016169133.mockapi.io/api/"

        fun launchDataLoad(
            onFailure: (Throwable) -> Unit,
            block: suspend () -> Unit
        ): Job {
            return CoroutineScope(Dispatchers.IO).launch {
                try {
                    block()
                } catch (error: Throwable) {
                    onFailure(error)
                }
            }
        }
    }
}