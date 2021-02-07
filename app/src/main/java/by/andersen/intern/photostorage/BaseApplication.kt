package by.andersen.intern.photostorage

import android.app.Application
import by.andersen.intern.photostorage.data.JsonPlaceHolderApi
import by.andersen.intern.photostorage.data.Repository
import by.andersen.intern.photostorage.domain.UseCase
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BaseApplication: Application() {
    private lateinit var repository: Repository
    lateinit var useCase: UseCase

    override fun onCreate() {
        super.onCreate()

        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi::class.java)
        repository = Repository(jsonPlaceHolderApi)
        useCase = UseCase(repository)
    }

    companion object {
        private const val BASE_URL = "https://api.unsplash.com"
    }
}