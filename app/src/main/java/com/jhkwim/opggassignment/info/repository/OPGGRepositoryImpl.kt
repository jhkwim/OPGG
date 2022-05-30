package com.jhkwim.opggassignment.info.repository

import android.util.Log
import androidx.lifecycle.*
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

    override suspend fun getSummoner(): LiveData<Summoner?> {
        return summonerDao.getSummoner().asLiveData().map {
            if (it.isEmpty()) null else it[0].toSummoner()
        }
//
//        Log.i("jhkim", "getSummoner : $summoners")
//
//        val ret = MediatorLiveData<Summoner?>()
//        ret.addSource(summoners) {
//            ret.value = if (it.isEmpty()) null else it[0].toSummoner()
//        }
//
//        return ret
    }

    override suspend fun fetchGameInfo(summonerName: String, createDate: String?) {
        val gameInfo = opggService.getGameInfo(summonerName, createDate)
        gameInfoDao.deleteAllGameInfo()
        gameInfoDao.insertGameInfo(DGameInfo.from(summonerName, gameInfo))
    }

    override suspend fun getGameInfo(): LiveData<GameInfo?> {
        return gameInfoDao.getGameInfo().asLiveData().map {
            if (it.isEmpty()) null else it[0].toGameInfo()
        }
//
//        val ret = MediatorLiveData<GameInfo?>()
//        ret.addSource(gameInfo) {
//            ret.value = if (it.isEmpty()) null else it[0].toGameInfo()
//        }
//
//        return ret
    }

    override suspend fun fetchAll(summonerName: String) {
        fetchSummoner(summonerName)
        fetchGameInfo(summonerName)
    }


}