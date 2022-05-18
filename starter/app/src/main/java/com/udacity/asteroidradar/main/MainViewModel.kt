package com.udacity.asteroidradar.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udacity.asteroidradar.api.MarsApi
import com.udacity.asteroidradar.api.parseAsteroidsJsonResult
import kotlinx.coroutines.launch
import org.json.JSONObject

class MainViewModel : ViewModel() {
    private val TAG = "MyActivity"


    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<String>()

    // The external immutable LiveData for the request status
    val status: LiveData<String> = _status
    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    init {
        getPosts()
    }

    private fun getPosts() {

        viewModelScope.launch {
            try {
                val listResult = MarsApi.retrofitService.getAsteroids()

                val jsonAsteroids = JSONObject(listResult)
                val dome = parseAsteroidsJsonResult(jsonAsteroids)
                //_status.value = "Success: ${getResult} Mars photos retrieved"
                Log.d(TAG, "my Message dome:  ${dome}")


            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
                Log.d(TAG, "Failure: ${e.message}")

            }
        }
    }
}