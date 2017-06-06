package dagger.nambv.app.demo.presenter

import dagger.nambv.app.demo.interactor.MainInteractor
import dagger.nambv.app.demo.model.Repo
import dagger.nambv.app.demo.view.fragment.PromotionsView
import javax.inject.Inject

class PromotionsPresenterImpl @Inject constructor(val view: PromotionsView, val mainInteractor: MainInteractor) : PromotionsPresenter, OnPromotionsCompletedListener {

    override fun requestRepoList(userName: String) {
        mainInteractor.getRepoList(userName, this)
    }

    override fun onRepoListRetrievalSuccess(data: List<Repo>) {
        view.showRepoList(data)
    }

    override fun onRepoListRetrievalFailure(errorMessage: String) {
        view.showError(errorMessage)
    }
}
