package com.jhkwim.opggassignment.info.repository.db

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jhkwim.opggassignment.info.repository.model.summoner.LadderRank
import com.jhkwim.opggassignment.info.repository.model.summoner.League
import com.jhkwim.opggassignment.info.repository.model.summoner.Summoner
import com.jhkwim.opggassignment.info.repository.model.summoner.TierRank

@Entity(tableName = "SMN_OPGG")
data class DSummoner(
    @PrimaryKey
    val name: String,
    val level: Int,
    val profileImageUrl: String,
    val profileBorderImageUrl: String,
    val profileBackgroundImageUrl: String,
    val url: String,
    val leagues: List<League>,
    val previousTiers: List<TierRank>,
    @Embedded val ladderRank: LadderRank
) {

    companion object {

        fun from(summoner: Summoner): DSummoner {
            return DSummoner(
                summoner.name,
                summoner.level,
                summoner.profileImageUrl,
                summoner.profileBorderImageUrl,
                summoner.profileBackgroundImageUrl,
                summoner.url,
                summoner.leagues,
                summoner.previousTiers,
                summoner.ladderRank
            )
        }

    }

    fun toSummoner(): Summoner {
        return Summoner(
            name,
            level,
            profileImageUrl,
            profileBorderImageUrl,
            profileBackgroundImageUrl,
            url,
            leagues,
            previousTiers,
            ladderRank
        )
    }

}