package com.jhkwim.opggassignment.base

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.JsonIOException
import kotlinx.coroutines.CoroutineExceptionHandler

open class BaseViewModel : ViewModel() {

    private val _fetchState = MutableLiveData<FetchState>()
    val fetchState: LiveData<FetchState> = _fetchState

    protected val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.e("ViwModel", throwable.localizedMessage, throwable)
        throwable.printStackTrace()

        when (throwable) {
            is JsonIOException -> _fetchState.postValue(FetchState.ERROR_PARSE)
            else -> _fetchState.postValue(FetchState.ERROR_UNKNOWN)
        }
    }

}