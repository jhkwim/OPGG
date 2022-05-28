package com.jhkwim.opggassignment.info.repository

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

    override suspend fun fetchSummoner() {
        val summoner = opggService.getSummoner()
        summonerDao.deleteAllSummoner()
        summonerDao.insertSummoner(summoner)
    }

    override suspend fun getSummoner(): Summoner? {
        return summonerDao.getSummoner()
    }

    override suspend fun fetchGameInfo(createDate: String?) {
        val gameInfo = opggService.getGameInfo(createDate)
        gameInfoDao.deleteAllGameInfo()
        gameInfoDao.insertGameInfo(gameInfo)
    }


    override suspend fun getGameInfo(): GameInfo? {
        return gameInfoDao.getGameInfo()
    }

}