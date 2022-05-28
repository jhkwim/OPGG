package com.jhkwim.opggassignment.info.repository.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [GameInfoEntity::class, SummonerEntity::class],
    version = 1
)
abstract class OPGGDatabase : RoomDatabase() {

    abstract fun gameInfoDao(): GameInfoDao

    abstract fun summonerDao(): SummonerDao

    companion object {
        private var INSTANCE: OPGGDatabase? = null

        fun getInstance(context: Context): OPGGDatabase? {
            if (INSTANCE == null) {
                synchronized(OPGGDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        OPGGDatabase::class.java,
                        "opgg-db"
                    ).build()
                }
            }

            return INSTANCE
        }
    }
}