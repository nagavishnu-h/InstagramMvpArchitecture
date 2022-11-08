package rapido.bike.paathshaala.instagrammvparchitecture.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import rapido.bike.paathshaala.instagrammvparchitecture.R
import rapido.bike.paathshaala.instagrammvparchitecture.instagraminterface.InstagramInterface
import rapido.bike.paathshaala.instagrammvparchitecture.model.PostCard
import rapido.bike.paathshaala.instagrammvparchitecture.presenter.InstagramPresenter

class MainActivity : AppCompatActivity(), InstagramInterface.View {
    private var postFeedPresenter: InstagramPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        postFeedPresenter = InstagramPresenter(this)
    }

    override fun displayFeeds(data: List<PostCard>) {
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerview.layoutManager = LinearLayoutManager(this)
        val postFeedAdapter = PostFeedAdapter(this, data)
        recyclerview.adapter = postFeedAdapter
    }
}