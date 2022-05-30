package com.jhkwim.opggassignment.info.repository.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.jhkwim.opggassignment.info.repository.model.game.*
import com.jhkwim.opggassignment.info.repository.model.summoner.League
import com.jhkwim.opggassignment.info.repository.model.summoner.TierRank

class Converters {

    @TypeConverter
    fun listToJson(value: List<League>) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<League>::class.java).toList()

    @TypeConverter
    fun listToJson1(value: List<TierRank>) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList1(value: String) = Gson().fromJson(value, Array<TierRank>::class.java).toList()

    @TypeConverter
    fun listToJson3(value: List<Game>) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList3(value: String) = Gson().fromJson(value, Array<Game>::class.java).toList()

    @TypeConverter
    fun listToJson4(value: List<Champion>) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList4(value: String) = Gson().fromJson(value, Array<Champion>::class.java).toList()

    @TypeConverter
    fun listToJson5(value: List<Position>) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList5(value: String) = Gson().fromJson(value, Array<Position>::class.java).toList()

    @TypeConverter
    fun listToJson6(value: List<Spell>) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList6(value: String) = Gson().fromJson(value, Array<Spell>::class.java).toList()

    @TypeConverter
    fun listToJson7(value: List<Item>) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList7(value: String) = Gson().fromJson(value, Array<Item>::class.java).toList()

    @TypeConverter
    fun listToJson8(value: List<Stats>) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList8(value: String) = Gson().fromJson(value, Array<Stats>::class.java).toList()

}