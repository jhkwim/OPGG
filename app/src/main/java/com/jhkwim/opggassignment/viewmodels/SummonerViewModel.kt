package com.jhkwim.opggassignment.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jhkwim.opggassignment.base.BaseViewModel
import com.jhkwim.opggassignment.info.repository.OPGGRepository
import com.jhkwim.opggassignment.info.repository.model.summoner.Summoner
import kotlinx.coroutines.launch

class SummonerViewModel(val opggRepository: OPGGRepository) : BaseViewModel() {

    private val _summoner = MediatorLiveData<Summoner>()
    val summoner: LiveData<Summoner> = _summoner

    fun fetchSummoner() = viewModelScope.launch(exceptionHandler) {
        opggRepository.fetchSummoner("genetory")
        _summoner.addSource(opggRepository.getSummoner()) {
            _summoner.value = it
        }
    }

    fun refresh() = viewModelScope.launch(exceptionHandler) {
        opggRepository.fetchAll("genetory")
    }
}