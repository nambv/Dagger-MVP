package dagger.nambv.app.demo.interactor

import dagger.nambv.app.demo.presenter.OnPromotionsCompletedListener

interface MainInteractor {
    fun getRepoList(userName: String, listener: OnPromotionsCompletedListener)
}
