package by.andersen.intern.photostorage.data.model

import com.google.gson.annotations.SerializedName

class User (val id: String,
            val username: String,
            val name: String,
            @SerializedName("portfolio_url")
            val portfolioUrl: String,
            val bio: String,
            location: String,
            @SerializedName("total_likes")
            val totalLikes: Int,
            @SerializedName("total_photos")
            val totalPhotos: Int,
            @SerializedName("total_collections")
            val totalCollections: Int,
            @SerializedName("instagram_username")
            val instagramUsername: String,
            @SerializedName("twitter_username")
            val twitterUsername: String,
            @SerializedName("profile_image")
            val profileImage: ProfileImage,
            val links: UsersLinks
)
