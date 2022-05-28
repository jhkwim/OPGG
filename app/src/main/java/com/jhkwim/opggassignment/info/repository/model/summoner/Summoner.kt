package com.jhkwim.opggassignment.info.repository.model.summoner

data class Summoner(
    val name: String,
    val level: Int,
    val profileImageUrl: String,
    val profileBorderImageUrl: String,
    val profileBackgroundImage: String,
    val url: String,
    val leagues: List<League>,
    val previousTiers: List<TierRank>,
    val ladderRank: LadderRank
)
