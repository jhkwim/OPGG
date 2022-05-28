package com.jhkwim.opggassignment.info.repository.model.game

data class Champion(
    val id: Int,
    val key: String,
    val name: String,
    val imageUrl: String,
    val games: Int,
    val kills: Int,
    val deaths: Int,
    val assists: Int,
    val wins: Int,
    val losses: Int,
    val level: Int
)
