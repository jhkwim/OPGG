package com.jhkwim.opggassignment.info.repository.db

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jhkwim.opggassignment.info.repository.model.game.*

@Entity(tableName = "GIE_OPGG")
data class DGameInfo(
    @PrimaryKey val summonerOwnerName: String,
    val games: List<Game>,
    val champions: List<Champion>,
    val positions: List<Position>,
    @Embedded val summary: Summary
) {

    companion object {

        fun from(summonerOwnerName: String, gameInfo: GameInfo): DGameInfo {
            return DGameInfo(
                summonerOwnerName,
                gameInfo.games,
                gameInfo.champions,
                gameInfo.positions,
                gameInfo.summary
            )
        }
    }

    fun toSummoner(): GameInfo {
        return GameInfo(
            games,
            champions,
            positions,
            summary
        )
    }

}