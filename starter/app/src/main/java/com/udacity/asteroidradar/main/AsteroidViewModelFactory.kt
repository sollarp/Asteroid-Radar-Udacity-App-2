package com.udacity.asteroidradar.main

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.udacity.asteroidradar.dataBase.AsteroidDao
import com.udacity.asteroidradar.dataBase.ImageDao

class AsteroidViewModelFactory(private val dataSource: AsteroidDao,
                               //private val imageDao: ImageDao,
                               private val application: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(
                dataSource,
                //imageDao,
                application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}