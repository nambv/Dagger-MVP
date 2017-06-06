package dagger.nambv.app.demo.interactor

import javax.inject.Inject

import dagger.nambv.app.demo.model.Repo
import dagger.nambv.app.demo.presenter.OnPromotionsCompletedListener
import dagger.nambv.app.demo.service.NetworkService
import rx.Observer
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MainInteractorImpl @Inject constructor() : MainInteractor {

    @Inject
    lateinit var networkService: NetworkService

    override fun getRepoList(userName: String, listener: OnPromotionsCompletedListener) {
        networkService.getRepoList(userName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<List<Repo>> {
                override fun onCompleted() {}

                override fun onError(e: Throwable) {
                    listener.onRepoListRetrievalFailure("Unable to get repo items: " + e.message)
                }

                override fun onNext(repoList: List<Repo>) {
                    listener.onRepoListRetrievalSuccess(repoList)
                }
            })
    }
}
