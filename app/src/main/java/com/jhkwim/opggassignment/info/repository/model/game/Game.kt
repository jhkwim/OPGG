package com.jhkwim.opggassignment.info.repository.model.game

data class Game(
    val mmr: Int,
    val champion: Champion,
    val spells: List<Spell>,
    val items: List<Item>,
    val needRenew: Boolean,
    val gameId: Long,
    val createDate: String,
    val gameLength: Int,
    val gameType: String,
    val summonerId: String,
    val summonerName: String,
    val tierRankShort: String,
    val stats: List<Stat>,
    val mapInfo: String,
    val peak: Map<Int, String>,
    val isWin: Boolean
)
