package com.jhkwim.opggassignment.info.repository.db

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jhkwim.opggassignment.info.repository.model.summoner.Summoner

@Entity(tableName = "SMN_OPGG")
data class SummonerEntity(
    @PrimaryKey val id: Int,
    @Embedded @ColumnInfo(name = "summoner") val summoner: Summoner
)