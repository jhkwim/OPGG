package com.jhkwim.opggassignment.info.repository.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface SummonerDao {

    @Query("SELECT * FROM SMN_OPGG")
    fun getSummoner(): Flow<List<DSummoner>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSummoner(summoner: DSummoner)

    @Query("DELETE from SMN_OPGG")
    suspend fun deleteAllSummoner()

    @Delete
    suspend fun deleteSummoner(summoner: DSummoner)

}