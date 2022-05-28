package com.jhkwim.opggassignment.info.repository.db

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jhkwim.opggassignment.info.repository.model.game.GameInfo

@Entity(tableName = "GIE_OPGG")
data class GameInfoEntity(
    @PrimaryKey val id: Int,
    @Embedded @ColumnInfo(name = "game_info") val gameInfo: GameInfo
)