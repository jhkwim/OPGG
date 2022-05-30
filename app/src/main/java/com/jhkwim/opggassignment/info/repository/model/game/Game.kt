package com.jhkwim.opggassignment.info.repository.model.game

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

data class Game(
    @SerializedName("champion")
    val champion: ChampionX,
    val createDate: Long,
    val gameId: String,
    val gameLength: Int,
    val gameType: String,
    val isWin: Boolean,
    val items: List<Item>,
    val mapInfo: Any,
    val mmr: Int,
    val needRenew: Boolean,
    val peak: List<String?>,
    val spells: List<Spell>,
    val stats: Stats,
    val summonerId: String,
    val summonerName: String,
    val tierRankShort: String
) {

    fun calTime(): String{
        val create = Calendar.getInstance()
        create.timeInMillis = createDate
        val day = Calendar.getInstance().get(Calendar.DAY_OF_YEAR) - create.get(Calendar.DAY_OF_YEAR)
        val hour = Calendar.getInstance().get(Calendar.HOUR) - create.get(Calendar.HOUR)
        val min = Calendar.getInstance().get(Calendar.MINUTE) - create.get(Calendar.MINUTE)

        return if (day > 0) {
            "${day}일 전"
        } else if (hour > 0) {
            "${hour}시간 전"
        } else {
            "${min}분 전"
        }
    }

    fun getSpellUrl(i: Int) = spells.getOrNull(i)?.imageUrl

    fun getItemUrl(i: Int) = items.getOrNull(i)?.imageUrl

    fun getPeakUrl(i: Int) = peak.getOrNull(i)

}