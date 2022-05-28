package com.jhkwim.opggassignment.info.repository.model.game

data class Summary(
    val wins: Int,
    val losses: Int,
    val kills: Int,
    val deaths: Int,
    val assists: Int
)
