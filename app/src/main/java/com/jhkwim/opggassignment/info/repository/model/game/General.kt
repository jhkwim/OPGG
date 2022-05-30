package com.jhkwim.opggassignment.info.repository.model.game

data class General(
    val assist: Int,
    val contributionForKillRate: String,
    val cs: Int,
    val csPerMin: Double,
    val death: Int,
    val goldEarned: Int,
    val kdaString: String,
    val kill: Int,
    val largestMultiKillString: String,
    val opScoreBadge: String,
    val totalDamageDealtToChampions: Int
) {

    fun strKill() = "$kill"

    fun strDeath() = "$death"

    fun strAssist() = "$assist"

    fun strContributionForKillRate() = "킬관여 $contributionForKillRate"
}