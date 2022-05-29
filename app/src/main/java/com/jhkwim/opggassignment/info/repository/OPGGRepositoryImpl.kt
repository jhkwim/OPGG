package com.jhkwim.opggassignment.info.repository

import android.util.Log
import com.google.gson.Gson
import com.jhkwim.opggassignment.info.repository.db.DGameInfo
import com.jhkwim.opggassignment.info.repository.db.DSummoner
import com.jhkwim.opggassignment.info.repository.db.GameInfoDao
import com.jhkwim.opggassignment.info.repository.db.SummonerDao
import com.jhkwim.opggassignment.info.repository.model.game.GameInfo
import com.jhkwim.opggassignment.info.repository.model.summoner.Summoner
import com.jhkwim.opggassignment.info.repository.network.OPGGService

class OPGGRepositoryImpl(
    val opggService: OPGGService,
    val summonerDao: SummonerDao,
    val gameInfoDao: GameInfoDao
) : OPGGRepository {

    override suspend fun fetchSummoner(summonerName: String) {
        val result = opggService.getSummoner(summonerName)
        Log.i("jhkim", result.toString())
        summonerDao.deleteAllSummoner()
        summonerDao.insertSummoner(DSummoner.from(result.summoner))
    }

    override suspend fun getSummoner(): Summoner? {
        val summoners = summonerDao.getSummoner()

        Log.i("jhkim", "getSummoner : $summoners")


        return if (summoners.isEmpty()) null else summoners[0].toSummoner()
    }

    override suspend fun fetchGameInfo(summonerName: String, createDate: String?) {
        val gameInfo = opggService.getGameInfo(summonerName, createDate)
        gameInfoDao.deleteAllGameInfo()
        gameInfoDao.insertGameInfo(DGameInfo.from(summonerName, gameInfo))
    }

    override suspend fun getGameInfo(): GameInfo? {
        val gameInfo = gameInfoDao.getGameInfo()
        return if (gameInfo.isEmpty()) null else gameInfo[0].toSummoner()
    }



}