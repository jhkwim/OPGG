package com.jhkwim.opggassignment.info.repository.model.game

import com.jhkwim.opggassignment.info.const.Position_

data class Position(
    val games: Int,
    val wins: Int,
    val losses: Int,
    val position: Position_,
    val positionName: String
)
