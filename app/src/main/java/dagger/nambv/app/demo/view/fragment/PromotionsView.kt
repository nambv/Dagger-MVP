package dagger.nambv.app.demo.view.fragment

import dagger.nambv.app.demo.model.Repo

interface PromotionsView {
    fun showRepoList(values: List<Repo>)
    fun showError(errorMessage: String)
}
