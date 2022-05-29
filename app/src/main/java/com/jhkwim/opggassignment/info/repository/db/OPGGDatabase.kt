package com.jhkwim.opggassignment.info.repository.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [DGameInfo::class, DSummoner::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class OPGGDatabase : RoomDatabase() {

    abstract fun gameInfoDao(): GameInfoDao

    abstract fun summonerDao(): SummonerDao

    abstract fun summonerInfoDao(): SummonerInfoDao

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