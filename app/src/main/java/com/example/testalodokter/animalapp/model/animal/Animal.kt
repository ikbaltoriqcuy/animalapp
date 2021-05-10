package com.example.testalodokter.animalapp.model.animal

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "animal")
class Animal (
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = false)
    @SerializedName("id")
    @Expose
    val id: Int,
    @ColumnInfo(name = "category")
    @SerializedName("category")
    @Expose
    val category: String,
    @ColumnInfo(name = "listImgSrc")
    @SerializedName("listImgSrc")
    @Expose
    @field:TypeConverters(AnimalTypeConverter::class)
    val listImgSrc: ArrayList<Int>
)