package com.jhkwim.opggassignment.info.repository.model.game

data class Summary(
    val assists: Int,
    val deaths: Int,
    val kills: Int,
    val losses: Int,
    val wins: Int
) {

    fun winsOrLosses() = "${wins}승 ${losses}패"

}