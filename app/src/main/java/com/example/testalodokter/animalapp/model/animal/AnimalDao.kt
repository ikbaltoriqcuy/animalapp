package com.example.testalodokter.animalapp.model.animal

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AnimalDao {
    @Query("SELECT * FROM animal")
    fun get(): List<Animal>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(data: List<Animal>)

    @Query("DELETE FROM animal")
    fun delete()
}