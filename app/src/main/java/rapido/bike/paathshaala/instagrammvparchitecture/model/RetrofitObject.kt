package rapido.bike.paathshaala.instagrammvparchitecture.model

import android.util.Log
import rapido.bike.paathshaala.instagrammvparchitecture.apis.FeedPosts
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObject {
    private val feedPostsApi:FeedPosts
    private const val BASEURL = "http://192.168.29.194:3000/"
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        feedPostsApi = retrofit.create(FeedPosts::class.java)
    }

    fun getFeedPosts(
        onSuccess:(movieList: SinglePost) -> Unit,
        onError: () -> Unit
    ){
        val response = feedPostsApi.getFeeds()
        Log.d("Instagram", "Out of enqueue $response")

        feedPostsApi.getFeeds().enqueue(object: Callback<SinglePost> {
            override fun onResponse(call: Call<SinglePost>, response: Response<SinglePost>) {
                if(response.isSuccessful){
                    val responseBody = response.body()
                    if(responseBody!=null){
                        Log.d("Instagram", "in if block $responseBody")
                        onSuccess.invoke(responseBody)
                    }
                }else{
                    Log.d("Instagram", "else block")
                    onError.invoke()
                }
            }
            override fun onFailure(call: Call<SinglePost>, t: Throwable) {
                Log.d("Instagram", "onFailure")
                onError.invoke()
            }
        })
    }
}
