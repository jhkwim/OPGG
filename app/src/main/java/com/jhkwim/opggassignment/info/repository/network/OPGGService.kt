package com.jhkwim.opggassignment.info.repository.network

import com.google.gson.JsonObject
import com.jhkwim.opggassignment.info.repository.model.game.GameInfo
import com.jhkwim.opggassignment.info.repository.model.summoner.SummonerResult
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface OPGGService {

    @GET("/api/summoner/{name}")
    suspend fun getSummoner(@Path("name") summonerName: String): SummonerResult

    @GET("/api/summoner/{name}/matches")
    suspend fun getGameInfo(
        @Path("name") summonerName: String,
        @Query("lastMatch") createData: String?
    ): GameInfo

}