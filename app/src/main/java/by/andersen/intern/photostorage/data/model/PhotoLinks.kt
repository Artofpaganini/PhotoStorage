package by.andersen.intern.photostorage.data.model

import com.google.gson.annotations.SerializedName

class PhotoLinks (val self: String,
                  val html: String,
                  val download: String,
                  @SerializedName("download_location")
                  val downloadLocation: String,
)





