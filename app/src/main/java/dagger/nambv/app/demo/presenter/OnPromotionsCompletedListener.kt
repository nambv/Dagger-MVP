package dagger.nambv.app.demo.presenter

import dagger.nambv.app.demo.model.Repo

interface OnPromotionsCompletedListener {
    fun onRepoListRetrievalSuccess(data: List<Repo>)
    fun onRepoListRetrievalFailure(errorMessage: String)
}
