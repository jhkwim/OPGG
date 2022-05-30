package com.jhkwim.opggassignment.info.repository.model.game

import android.util.Log

data class GameInfo(
    val champions: List<Champion>,
    val games: List<Game>,
    val positions: List<Position>,
    val summary: Summary
) {

    fun avrKill() = if (games.isEmpty()) {
        "0"
    } else {
        var totalKill = 0.0f

        games.forEach {
            totalKill += it.stats.general.kill
        }

        "${totalKill / games.size}"
    }

    fun avrDeath() = if (games.isEmpty()) {
        "0"
    } else {
        var totalDeath = 0.0f

        games.forEach {
            totalDeath += it.stats.general.death
        }

        "${totalDeath / games.size}"
    }

    fun avrAssist() = if (games.isEmpty()) {
        "0"
    } else {
        var totalAssist = 0.0f

        games.forEach {
            totalAssist += it.stats.general.assist
        }

        "${totalAssist / games.size}"
    }
}