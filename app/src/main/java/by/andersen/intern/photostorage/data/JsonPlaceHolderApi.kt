package by.andersen.intern.photostorage.data

import by.andersen.intern.photostorage.data.model.Photo
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface JsonPlaceHolderApi {
    @GET("/photos")
    suspend fun getComments(@QueryMap parameters: Map<String, String>): List<Photo>
}