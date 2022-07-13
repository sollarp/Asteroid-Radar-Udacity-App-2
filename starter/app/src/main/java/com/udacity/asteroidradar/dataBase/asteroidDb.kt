package com.udacity.asteroidradar.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        AsteroidEntity::class,
        //DatabasePictureOfDay::class
               ],
        version = 1,
)
abstract class AsteroidDb : RoomDatabase() {
    abstract val asteroidDao: AsteroidDao
    //abstract val imageDao: ImageDao



    companion object {
        @Volatile
        private var INSTANCE: AsteroidDb? = null

        fun getInstance(context: Context): AsteroidDb {
            var instance = INSTANCE
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    AsteroidDb::class.java,
                    "AsteroidDb"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
            }
            return instance
        }
    }
}
