package com.jhkwim.opggassignment.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jhkwim.opggassignment.base.BaseViewModel
import com.jhkwim.opggassignment.info.repository.OPGGRepository
import com.jhkwim.opggassignment.info.repository.model.game.GameInfo
import kotlinx.coroutines.launch

class GameInfoViewModel(val opggRepository: OPGGRepository) : BaseViewModel() {

    private val _gameInfo = MediatorLiveData<GameInfo>()
    val gameInfo: LiveData<GameInfo> = _gameInfo

    fun fetchGameInfo() = viewModelScope.launch(exceptionHandler) {
        opggRepository.fetchGameInfo("genetory")
        _gameInfo.addSource(opggRepository.getGameInfo()) {
            _gameInfo.value = it
        }
    }

}