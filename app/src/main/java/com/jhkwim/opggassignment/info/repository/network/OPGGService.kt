package com.jhkwim.opggassignment.info.repository.network

import com.jhkwim.opggassignment.info.repository.model.game.GameInfo
import com.jhkwim.opggassignment.info.repository.model.summoner.Summoner
import retrofit2.http.GET
import retrofit2.http.Query

interface OPGGService {

    @GET("/api/summoner/genetory")
    suspend fun getSummoner(): Summoner

    @GET("/api/summoner/genetory/matches")
    suspend fun getGameInfo(
        @Query("lastMatch") createData: String?
    ): GameInfo

}