package com.jhkwim.opggassignment.info.repository.model.summoner

import com.google.gson.annotations.SerializedName

data class Summoner(
    @SerializedName("name") var name: String,
    @SerializedName("level") var level: Int,
    @SerializedName("profileImageUrl") var profileImageUrl: String,
    @SerializedName("profileBorderImageUrl") var profileBorderImageUrl: String,
    @SerializedName("profileBackgroundImageUrl") var profileBackgroundImageUrl: String,
    @SerializedName("url") var url: String,
    @SerializedName("leagues") var leagues: List<League>,
    @SerializedName("previousTiers") var previousTiers: List<TierRank>,
    @SerializedName("ladderRank") var ladderRank: LadderRank
)
