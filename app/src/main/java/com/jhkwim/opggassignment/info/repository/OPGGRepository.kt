package com.jhkwim.opggassignment.info.repository

import com.jhkwim.opggassignment.info.repository.model.game.GameInfo
import com.jhkwim.opggassignment.info.repository.model.summoner.Summoner

interface OPGGRepository {

    suspend fun fetchSummoner(summonerName: String)

    suspend fun getSummoner(): Summoner?

    suspend fun fetchGameInfo(summonerName: String, createDate: String? = null)

    suspend fun getGameInfo(): GameInfo?

}