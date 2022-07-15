package com.udacity.asteroidradar.dataBase

// ROOM step 1 careful of suspending @Insert

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ImageDao{

    @Query("select * from DatabasePictureOfDay")
    fun getPictureOfDay(): LiveData<DatabasePictureOfDay>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPOD(pictureOfDay: DatabasePictureOfDay)

}