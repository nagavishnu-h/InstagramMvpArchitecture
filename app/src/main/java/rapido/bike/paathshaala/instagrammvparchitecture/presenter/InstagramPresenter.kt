package rapido.bike.paathshaala.instagrammvparchitecture.presenter

import rapido.bike.paathshaala.instagrammvparchitecture.instagraminterface.InstagramInterface.*
import rapido.bike.paathshaala.instagrammvparchitecture.model.InstagramModel

class InstagramPresenter(_view: View):Presenter {
    private var view: View = _view
    private var model: Model = InstagramModel()

    init {
        displayData()
    }

    override fun displayData() {
        view.displayFeeds(model.getData())
    }
}