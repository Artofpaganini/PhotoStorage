package by.andersen.intern.photostorage.data

import android.util.Log
import by.andersen.intern.photostorage.data.model.Photo


class Repository(private val jsonPlaceHolderApi: JsonPlaceHolderApi) {

    suspend fun getPhotos(): List<Photo> {
        Log.i("mLog", "startRepository")
        val parameters: MutableMap<String, String> = HashMap()
        parameters[KEY] = KEY_VALUE
        val photos = jsonPlaceHolderApi.getComments(parameters)
        Log.i("mLog", "finishRepository")
        return photos
    }

    companion object {
        private const val KEY = "client_id"
        private const val KEY_VALUE = "bfXHrc5mpesUOLoQoBc4T5XmV0UC30A7ONZptkBXCXY"
    }
}