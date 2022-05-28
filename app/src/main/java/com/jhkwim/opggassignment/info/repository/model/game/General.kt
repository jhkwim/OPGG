package com.jhkwim.opggassignment.info.repository.model.game

data class General(
    val kill: Int,
    val death: Int,
    val assist: Int,
    val kdaString: String,
    val cs: Int,
    val csPerMin: Float,
    val contributionForKillRate: String,
    val goldEarned: Int,
    val totalDamageDealToChampions: Int,
    val largestMultiKillString: String,
    val opScoreBadge: String
)
