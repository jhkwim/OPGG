package com.jhkwim.opggassignment.info.repository.model.game

import androidx.room.Embedded

data class GameInfo(
    val games: List<Game>,
    val champions: List<Champion>,
    val positions: List<Position>,
    @Embedded val summary: Summary
)
