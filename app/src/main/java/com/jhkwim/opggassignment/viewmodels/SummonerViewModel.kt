package com.jhkwim.opggassignment.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jhkwim.opggassignment.base.BaseViewModel
import com.jhkwim.opggassignment.info.repository.OPGGRepository
import com.jhkwim.opggassignment.info.repository.model.summoner.Summoner
import kotlinx.coroutines.launch

class SummonerViewModel(val opggRepository: OPGGRepository) : BaseViewModel() {

    private val _summoner = MutableLiveData<Summoner>()
    val summoner: LiveData<Summoner> = _summoner

    fun fetchSummoner() = viewModelScope.launch(exceptionHandler) {
        opggRepository.fetchSummoner("genetory")
        _summoner.value = opggRepository.getSummoner()
    }
}