package com.jhkwim.opggassignment.info.repository.model.game

data class Position(
    val games: Int,
    val losses: Int,
    val position: String,
    val positionName: String,
    val wins: Int
)