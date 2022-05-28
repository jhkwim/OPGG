package com.jhkwim.opggassignment.info.repository.model.game

data class GameInfo(
    val games: List<Game>,
    val champions: List<Champion>,
    val positions: List<Position>,
    val summary: Summary
)
