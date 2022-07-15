package com.udacity.asteroidradar.main

import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*
import coil.ImageLoader
import coil.ImageLoaderFactory
import com.udacity.asteroidradar.Asteroid
import com.udacity.asteroidradar.PictureOfDay
import com.udacity.asteroidradar.api.MarsApi
import com.udacity.asteroidradar.api.parseAsteroidsJsonResult
import com.udacity.asteroidradar.asDatabaseModel
import com.udacity.asteroidradar.dataBase.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class MainViewModel(
    private val dataBase: AsteroidDao,
    private val imageDb: ImageDao,
    application: Application
) : AndroidViewModel(application), ImageLoaderFactory {
    private val TAG = "MyActivity"

    private val currentDate = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE)
    private val startDate = LocalDateTime.now().plusDays(7).format(DateTimeFormatter.ISO_DATE)
    lateinit var getListBack : List<Asteroid>


    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<String>()
    var getDome = ArrayList<Asteroid>()

    // The external immutable LiveData for the request status
    val status: LiveData<String> = _status

    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    //private val _property = MutableLiveData<MarsProperty>()
    val _dome = MutableLiveData<List<Asteroid>>()
    val dome: LiveData<List<Asteroid>>
        get() = _dome


    init {
        viewModelScope.launch {
            getAsteroidsUpdate()
            getAsteroidFromDatabase()

        }
    }

    private suspend fun getAsteroidsUpdate() {
        try {

            val listResult = MarsApi.retrofitService.getAsteroids(startDate, currentDate)
            val pictureOfDay = MarsApi.retrofitService.getImageOfTheDay()

            //val pictureOfDayBitmap = getBitmap(pictureOfDay)
            //Log.d(TAG, "start end: ${pictureOfDayBitmap}")
            val jsonAsteroids = JSONObject(listResult)
            getDome = parseAsteroidsJsonResult(jsonAsteroids)
            val networkAsteroidList = getDome.map {
                Asteroid(
                    it.id,
                    it.codename,
                    it.closeApproachDate,
                    it.absoluteMagnitude,
                    it.estimatedDiameter,
                    it.relativeVelocity,
                    it.distanceFromEarth,
                    it.isPotentiallyHazardous
                )
            }
            insertAll(networkAsteroidList)
            insertPictureInDatabase(pictureOfDay)
            //getMostRecentPictureFromDatabase()
        } catch (e: Exception) {
            Toast.makeText(getApplication(),"Error Loading",Toast.LENGTH_SHORT).show()
        }
    }
    
    private val _pictureOfDay: LiveData<DatabasePictureOfDay> =
        Transformations.map(imageDb.getPictureOfDay()){
            it.asDomainModelPicture()
        }
    val pictureOfDay: LiveData<DatabasePictureOfDay>
        get() = _pictureOfDay



    fun getMostRecentPictureFromDatabase(): LiveData<String> {
        val getUrl = imageDb.getPictureOfDay().map { it.asDomainModelPicture().url}
        return getUrl
    }
    suspend fun insertPictureInDatabase(databasePictureOfDay: DatabasePictureOfDay) {
    withContext(Dispatchers.IO) {
       imageDb.insertPOD(databasePictureOfDay.asDomainModelPicture())
    }
    }

    private suspend fun insertAll(networkAsteroidList: List<Asteroid>) {
        withContext(Dispatchers.IO) {
            dataBase.insertAll(*networkAsteroidList.asDatabaseModel())
        }
    }

    private suspend fun getAsteroidFromDatabase(){
        withContext(Dispatchers.IO) {
            val gettingIt = dataBase.getAllSavedAsteroids()
            getListBack = gettingIt.asDomainModel()
            //Log.d(TAG, "data base get ${getListBack}")
        }
        _dome.value = getListBack
    }

    /**
     * Return a new [ImageLoader].
     */
    override fun newImageLoader(): ImageLoader {
        return ImageLoader.Builder(this.getApplication())
            .crossfade(true)
            .build()
    }
//    private suspend fun getBitmap(pictureOfDay: PictureEntity): Bitmap {
//        val request = ImageRequest.Builder(getApplication())
//            .data(pictureOfDay.url)
//            .build()
//        val result = (newImageLoader().execute(request) as SuccessResult).drawable
//        return (result as BitmapDrawable).bitmap
//    }
}