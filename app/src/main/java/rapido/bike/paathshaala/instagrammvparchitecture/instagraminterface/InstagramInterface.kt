package rapido.bike.paathshaala.instagrammvparchitecture.instagraminterface

import rapido.bike.paathshaala.instagrammvparchitecture.model.PostCard

interface InstagramInterface {
    interface View {
        fun displayFeeds(data: List<PostCard>)
    }

    interface Presenter {
        fun displayData()
    }

    interface Model {
        fun getData(): List<PostCard>
    }

}