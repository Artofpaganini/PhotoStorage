package by.andersen.intern.photostorage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import by.andersen.intern.photostorage.presentation.util.PhotoAdapter
import by.andersen.intern.photostorage.presentation.util.PhotoItem

class StartFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private var dataset = ArrayList<PhotoItem>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view?.findViewById<RecyclerView>(R.id.photo_recycler_view)!!
        recyclerView.adapter = PhotoAdapter(dataset)

        dataset.add(PhotoItem("Dell", "https://images.unsplash.com/profile-1612719543089-689cf16f06bfimage?ixlib=rb-1.2.1\\u0026q=80\\u0026fm=jpg\\u0026crop=faces\\u0026cs=tinysrgb\\u0026fit=crop\\u0026h=32\\u0026w=32",
            "https://images.unsplash.com/photo-1612701571595-7a9a09a7d78b?crop=entropy\\u0026cs=tinysrgb\\u0026fit=max\\u0026fm=jpg\\u0026ixid=MXwyMDQxNDl8MHwxfGFsbHwzfHx8fHx8Mnw\\u0026ixlib=rb-1.2.1\\u0026q=80\\u0026w=400",
            false))

        dataset.add(PhotoItem("xps", "https://images.unsplash.com/profile-1600096866391-b09a1a53451aimage?ixlib=rb-1.2.1\\u0026q=80\\u0026fm=jpg\\u0026crop=faces\\u0026cs=tinysrgb\\u0026fit=crop\\u0026h=32\\u0026w=32",
            "https://images.unsplash.com/photo-1593643946890-b5b85ade6451?crop=entropy\\u0026cs=tinysrgb\\u0026fit=max\\u0026fm=jpg\\u0026ixid=MXwyMDQxNDl8MXwxfGFsbHwxfHx8fHx8Mnw\\u0026ixlib=rb-1.2.1\\u0026q=80\\u0026w=400",
            true))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_start, container, false)
    }
}