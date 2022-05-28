package com.jhkwim.opggassignment.info.repository.model.summoner

data class League(
    val hasResults: Boolean,
    val wins: Int,
    val losses: Int,
    val tierRank: TierRank
)
