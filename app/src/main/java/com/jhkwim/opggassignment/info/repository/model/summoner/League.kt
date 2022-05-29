package com.jhkwim.opggassignment.info.repository.model.summoner

data class League(
    val hasResults: Boolean,
    val wins: Int,
    val losses: Int,
    val tierRank: TierRank
) {
    fun record(): String = "${wins}승 ${losses}패 (${(wins.toFloat() / losses * 100).toInt()}%)"
}
