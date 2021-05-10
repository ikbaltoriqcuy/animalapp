package com.example.testalodokter.animalapp.model.animal

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlin.collections.ArrayList

class AnimalTypeConverter {
    private val gson = Gson()

    @TypeConverter
    fun stringToList(data: String?): ArrayList<Int> {
        if (data == null) {
            return ArrayList()
        }
        val listType = object : TypeToken<ArrayList<Int>>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun listToString(someObjects: ArrayList<Int>): String {
        return gson.toJson(someObjects)
    }
}