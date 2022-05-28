package com.jhkwim.opggassignment.info.repository.model.summoner

import com.jhkwim.opggassignment.info.const.Tier

data class TierRank(
    val name: String,
    val tier: Tier,
    val tierDivision: Tier,
    val string: String,
    val shortString: String,
    val division: String,
    val imageUrl: String,
    val lp: Int,
    val tierRankPoint: Int,
    val season: Int = 0
)
