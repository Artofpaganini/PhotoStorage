package by.andersen.intern.photostorage.presentation.start

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import by.andersen.intern.photostorage.domain.UseCase

class StartViewModelProviderFactory (val useCase: UseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when (modelClass) {
            StartViewModel::class.java -> StartViewModel(useCase) as T
            else -> throw Exception("Class is not StartViewModel")
        }
    }
}