package com.jhkwim.opggassignment.info.repository.model.summoner

import java.text.DecimalFormat

data class TierRank(
    val name: String,
    val tier: String,
    val tierDivision: String,
    val string: String,
    val shortString: String,
    val division: String,
    val imageUrl: String,
    val lp: Int,
    val tierRankPoint: Int,
    val season: Int = 0
) {

    fun formattedLP(): String {
        val format = DecimalFormat("#,###")
        return "${format.format(lp)} LP"
    }

}
