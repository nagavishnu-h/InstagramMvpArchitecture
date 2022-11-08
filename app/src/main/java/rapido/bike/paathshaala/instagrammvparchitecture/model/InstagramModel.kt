package rapido.bike.paathshaala.instagrammvparchitecture.model

import android.util.Log
import rapido.bike.paathshaala.instagrammvparchitecture.instagraminterface.InstagramInterface

class InstagramModel:InstagramInterface.Model {
    override fun getData(): List<PostCard> {
        var fetchedData:SinglePost ?= null
        RetrofitObject.getFeedPosts(
            onSuccess = {
                Log.e("Instagram","Feed List Size: $it")
                fetchedData=it
            },
            onError = {
                Log.e("Instagram","Some Error Occurred.")
            }
        )
        val data = ArrayList<PostCard>()
        for (i in 1..5){
            data.add(
                PostCard(
                "https://play-lh.googleusercontent.com/9HyDHKMpf6qa6EPhUbX3qgVmdbCQnkYtQxjoM_GgAaQCBlGY0XJcgYiu5jpnm0nZP6Q=w240-h480-rw",
                "rapidoapp",
                "https://i0.wp.com/s3.ap-south-1.amazonaws.com/img.paisawapas/images/2022/07/15171839/Frame-1968.jpg?fit=1200%2C600&ssl=1",
                5,
                "This #InternationalTranslationDay, let's see if you can guess these popular songs correctly \uD83C\uDFB5"
            )
            )
        }
        return data
    }
}