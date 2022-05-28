package com.jhkwim.opggassignment.info.repository

import com.jhkwim.opggassignment.info.repository.model.game.GameInfo
import com.jhkwim.opggassignment.info.repository.model.summoner.Summoner

interface OPGGRepository {

    suspend fun fetchSummoner()

    suspend fun getSummoner(): Summoner?

    suspend fun fetchGameInfo(createDate: String? = null)

    suspend fun getGameInfo(): GameInfo?

}