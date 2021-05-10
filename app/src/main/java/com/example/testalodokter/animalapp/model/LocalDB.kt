package com.example.testalodokter.animalapp.model

import com.example.testalodokter.Config
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.testalodokter.animalapp.model.User.User
import com.example.testalodokter.animalapp.model.User.UserDAO
import com.example.testalodokter.animalapp.model.animal.Animal
import com.example.testalodokter.animalapp.model.animal.AnimalDao

@Database(
    entities = [
        User::class,
        Animal::class
    ], version = 2, exportSchema = false
)
abstract class LocalDB : RoomDatabase() {
    abstract fun userDAO(): UserDAO
    abstract fun animalDAO(): AnimalDao

    companion object {
        @Volatile
        private var INSTANCE: LocalDB? = null

        fun getDatabase(
            context: Context
        ): LocalDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LocalDB::class.java,
                    Config.LOCAL_DB_FILE
                ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }

        fun clearAllTable() {
            INSTANCE?.clearAllTables()
        }

    }
}