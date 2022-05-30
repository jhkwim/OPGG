package com.jhkwim.opggassignment.info.repository.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface GameInfoDao {

    @Query("SELECT * FROM GIE_OPGG")
    fun getGameInfo(): Flow<List<DGameInfo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGameInfo(gameInfo: DGameInfo)

    @Query("DELETE from GIE_OPGG")
    suspend fun deleteAllGameInfo()

    @Delete
    suspend fun deleteGameInfo(gameInfo: DGameInfo)

}