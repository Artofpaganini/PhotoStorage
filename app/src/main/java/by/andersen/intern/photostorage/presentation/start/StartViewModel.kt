package by.andersen.intern.photostorage.presentation.start

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.andersen.intern.photostorage.domain.UseCase
import by.andersen.intern.photostorage.presentation.start.util.PhotoItem
import kotlinx.coroutines.launch

class StartViewModel(private val useCase: UseCase) : ViewModel() {
    private var _listPhoto : MutableLiveData<List<PhotoItem>> = MutableLiveData()
    val listPhoto  = _listPhoto as LiveData<List<PhotoItem>>

    fun getPhotos() {
        viewModelScope.launch {
            Log.i("mLog", "startViewModel")
            val photoList = useCase.getPhotos()
                    .map {
                        PhotoItem(it.user.username, it.user.profileImage.medium, it.urls.small, it.likedByUser) }
            _listPhoto.value = photoList
            Log.i("mLog", "finishViewModel")
        }
    }

}