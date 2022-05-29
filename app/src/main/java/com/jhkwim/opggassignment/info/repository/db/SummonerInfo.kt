package com.jhkwim.opggassignment.info.repository.db

import androidx.room.Embedded
import androidx.room.Relation

data class SummonerInfo(
    @Embedded val summoner: DSummoner,
    @Relation(
        parentColumn = "name",
        entityColumn = "summonerOwnerName"
    )
    val gameInfo: DGameInfo
)
