package com.jhkwim.opggassignment.info.repository.model.game

data class Champion(
    val assists: Int,
    val deaths: Int,
    val games: Int,
    val id: Int,
    val imageUrl: String,
    val key: String,
    val kills: Int,
    val losses: Int,
    val name: String,
    val wins: Int
)