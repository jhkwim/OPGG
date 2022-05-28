package com.jhkwim.opggassignment.info.repository.db

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jhkwim.opggassignment.info.repository.model.game.GameInfo

interface GameInfoDao {

    @Query("SELECT * FROM GIE_OPGG LIMIT 1")
    suspend fun getGameInfo(): GameInfo?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGameInfo(gameInfo: GameInfo)

    @Query("DELETE from GIE_OPGG")
    suspend fun deleteAllGameInfo()

    @Delete
    suspend fun deleteGameInfo(gameInfo: GameInfo)

}