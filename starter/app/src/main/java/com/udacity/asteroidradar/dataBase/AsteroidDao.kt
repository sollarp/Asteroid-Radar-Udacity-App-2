package com.udacity.asteroidradar.dataBase

import android.graphics.Bitmap
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.room.*
import com.udacity.asteroidradar.Asteroid

private val TAG = "DAOactvity"


@Dao
interface AsteroidDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(asteroidEntity: Array<AsteroidEntity>)

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertAll(asteroidEntities: Array<AsteroidEntity>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(vararg asteroidEntity: AsteroidEntity)

    @Query("SELECT * FROM asteroidDb ORDER BY close_approach_date DESC")
    fun getAllSavedAsteroids(): List<AsteroidEntity>

    @Update
    fun update(asteroidEntity: AsteroidEntity)

//    @Query("SELECT * FROM imagesTable ORDER BY date DESC LIMIT 1")
//    suspend fun getMostRecentPicture(): PictureEntity

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertTodaysImage(pictureEntity: PictureEntity)
//    @Query("select * from DatabasePictureOfDay")
//    fun getPictureOfDay(): DatabasePictureOfDay

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertPOD(pictureOfDay: DatabasePictureOfDay)

}

