package rapido.bike.paathshaala.instagrammvparchitecture.apis

import rapido.bike.paathshaala.instagrammvparchitecture.model.SinglePost
import retrofit2.Call
import retrofit2.http.GET

interface FeedPosts {
    @GET("instagramFeed")
    fun getFeeds(): Call<SinglePost>
}