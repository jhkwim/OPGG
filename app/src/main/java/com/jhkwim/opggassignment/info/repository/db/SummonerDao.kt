package com.jhkwim.opggassignment.info.repository.db

import androidx.room.*
import com.jhkwim.opggassignment.info.repository.model.summoner.Summoner

@Dao
interface SummonerDao {

    @Query("SELECT * FROM SMN_OPGG")
    suspend fun getSummoner(): List<DSummoner>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSummoner(summoner: DSummoner)

    @Query("DELETE from SMN_OPGG")
    suspend fun deleteAllSummoner()

    @Delete
    suspend fun deleteSummoner(summoner: DSummoner)

}