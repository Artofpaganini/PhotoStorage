package by.andersen.intern.photostorage.presentation.start

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import by.andersen.intern.photostorage.BaseApplication
import by.andersen.intern.photostorage.R
import by.andersen.intern.photostorage.presentation.start.util.PhotoAdapter
import by.andersen.intern.photostorage.presentation.start.util.PhotoItem

class StartFragment : Fragment() {
    private lateinit var startViewModel: StartViewModel
    private lateinit var recyclerView: RecyclerView
    private var startAdapter = PhotoAdapter(ArrayList<PhotoItem>())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.photo_recycler_view)
        recyclerView.adapter = startAdapter

        val useCase = (activity?.application as BaseApplication).useCase
        startViewModel = ViewModelProvider(this, StartViewModelProviderFactory(useCase))
            .get(StartViewModel::class.java)


        startViewModel.getPhotos()
        startViewModel.listPhoto
                .observe(viewLifecycleOwner, Observer{ list: List<PhotoItem> ->
                    startAdapter.setDataSet(list as ArrayList<PhotoItem>) })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_start, container, false)
    }
}