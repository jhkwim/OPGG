package com.jhkwim.opggassignment.info.repository.db

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jhkwim.opggassignment.info.repository.model.summoner.Summoner

interface SummonerDao {

    @Query("SELECT * FROM SMN_OPGG LIMIT 1")
    suspend fun getSummoner(): Summoner?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSummoner(summoner: Summoner)

    @Query("DELETE from SMN_OPGG")
    suspend fun deleteAllSummoner()

    @Delete
    suspend fun deleteSummoner(summoner: Summoner)

}