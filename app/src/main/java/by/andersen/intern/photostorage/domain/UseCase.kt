package by.andersen.intern.photostorage.domain

import android.util.Log
import by.andersen.intern.photostorage.data.Repository
import by.andersen.intern.photostorage.data.model.Photo

class UseCase(val repository: Repository) {
    suspend fun getPhotos(): List<Photo> {
        Log.i("mLog", "startUseCase")
        val photos = repository.getPhotos()
        Log.i("mLog", "finishUseCase")
        return photos
    }

}