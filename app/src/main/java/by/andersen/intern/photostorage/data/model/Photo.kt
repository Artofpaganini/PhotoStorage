package by.andersen.intern.photostorage.data.model

import com.google.gson.annotations.SerializedName

class Photo (val id: String,
            @SerializedName("created_at")
            val createdAt: String,
            @SerializedName("updated_at")
            val updatedAt: String,
            val width: Int,
            val height: Int,
            val color: String,
            @SerializedName("blur_hash")
            val blurHash: String,
            val likes: Int,
            @SerializedName("liked_by_user")
            val likedByUser: Boolean,
            val description: String,
            val user: User,
            @SerializedName("current_user_collections")
            val currentUserCollections: List<UsersCollection>,
            val urls: PhotoUrls,
            val links: PhotoLinks
)