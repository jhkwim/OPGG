package com.jhkwim.opggassignment.info.repository.db

import androidx.room.*
import com.jhkwim.opggassignment.info.repository.model.game.GameInfo

@Dao
interface GameInfoDao {

    @Query("SELECT * FROM GIE_OPGG")
    suspend fun getGameInfo(): List<DGameInfo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGameInfo(gameInfo: DGameInfo)

    @Query("DELETE from GIE_OPGG")
    suspend fun deleteAllGameInfo()

    @Delete
    suspend fun deleteGameInfo(gameInfo: DGameInfo)

}