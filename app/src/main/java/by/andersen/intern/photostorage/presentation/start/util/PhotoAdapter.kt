package by.andersen.intern.photostorage.presentation.start.util

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import by.andersen.intern.photostorage.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop

class PhotoAdapter(private val dataSet: ArrayList<PhotoItem>) :
    RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val userName: TextView
        private val userAvatar: ImageView
        private val photo: ImageView
        private val isLiked: ImageView
        private val context: Context = view.context

        init {
            userName = view.findViewById(R.id.user_name)
            userAvatar = view.findViewById(R.id.user_avatar)
            photo = view.findViewById(R.id.photo)
            isLiked = view.findViewById(R.id.is_liked)
        }

        fun bind(photoItem: PhotoItem, position: Int) {
            userName.text = photoItem.userName

            Glide
                .with(context)
                .load(photoItem.userAvatar)
                .centerCrop()
                .transform(CircleCrop())
                .placeholder(R.drawable.ic_launcher_background)
                .into(userAvatar)

            Glide
                .with(context)
                .load(photoItem.photo)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(photo)

            when (photoItem.isLiked) {
                true -> isLiked.setImageResource(R.drawable.ic_like)
                false -> isLiked.setImageResource(R.drawable.ic_dont_like)
            }

        }
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.photo_item, viewGroup, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(dataSet[position], position)
    }


    override fun getItemCount() = dataSet.size

}
