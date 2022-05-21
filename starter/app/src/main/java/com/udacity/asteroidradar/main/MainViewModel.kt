package com.udacity.asteroidradar.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.udacity.asteroidradar.Asteroid
import com.udacity.asteroidradar.api.AsteroidApi
import com.udacity.asteroidradar.api.MarsApi
import com.udacity.asteroidradar.api.parseAsteroidsJsonResult
import kotlinx.coroutines.launch
import org.json.JSONObject

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val TAG = "MyActivity"


    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<String>()

    // The external immutable LiveData for the request status
    val status: LiveData<String> = _status
    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    //private val _property = MutableLiveData<MarsProperty>()
    private val _dome = MutableLiveData<String>()
    val dome: LiveData<String>
        get() = _dome

    init {
        getPosts()
    }

    private fun getPosts() {

        viewModelScope.launch {
            try {
                val listResult = MarsApi.retrofitService.getAsteroids()

                val jsonAsteroids = JSONObject(listResult)
                val getDome = parseAsteroidsJsonResult(jsonAsteroids)
                _dome.value = "Success: ${getDome} Mars photos retrieved"
                Log.d(TAG, "my Message dome:  ${getDome}")


            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
                Log.d(TAG, "Failure: ${e.message}")

            }
        }
    }
}