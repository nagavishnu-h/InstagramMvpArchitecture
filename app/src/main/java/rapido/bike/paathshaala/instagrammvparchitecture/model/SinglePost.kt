package rapido.bike.paathshaala.instagrammvparchitecture.model

import com.google.gson.annotations.SerializedName

data class SinglePost(
    @SerializedName("title") val title: String,
    @SerializedName("userPicture") val userPicture: String,
    @SerializedName("postPicture") val postPicture: String,
    @SerializedName("likeCount") val likeCount: String,
    @SerializedName("postDescription") val postDescription:String
)
