package com.jhkwim.opggassignment.info.repository

import androidx.lifecycle.LiveData
import com.jhkwim.opggassignment.info.repository.model.game.GameInfo
import com.jhkwim.opggassignment.info.repository.model.summoner.Summoner

interface OPGGRepository {

    suspend fun fetchSummoner(summonerName: String)

    suspend fun getSummoner(): LiveData<Summoner?>

    suspend fun fetchGameInfo(summonerName: String, createDate: String? = null)

    suspend fun getGameInfo(): LiveData<GameInfo?>

    suspend fun fetchAll(summonerName: String)

}