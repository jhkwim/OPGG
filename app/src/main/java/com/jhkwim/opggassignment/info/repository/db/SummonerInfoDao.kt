package com.jhkwim.opggassignment.info.repository.db

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface SummonerInfoDao {

    @Transaction
    @Query("SELECT * FROM SMN_OPGG")
    fun getSummonerInfo(): List<SummonerInfo>

}