package dagger.nambv.app.demo.interactor;

import java.util.List;

import javax.inject.Inject;

import dagger.nambv.app.demo.model.Repo;
import dagger.nambv.app.demo.presenter.OnPromotionsCompletedListener;
import dagger.nambv.app.demo.service.NetworkService;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainInteractorImpl implements MainInteractor {

    @Inject
    NetworkService repoListService;

    @Inject
    public MainInteractorImpl() {}

    @Override
    public void getRepoList(String userName, OnPromotionsCompletedListener listener) {
        if (userName == null || userName.equals("")) {
            listener.onRepoListRetrievalFailure("Username must be provided!");
            return;
        }

        repoListService.getRepoList(userName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Repo>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onRepoListRetrievalFailure("Unable to get repo items: " + e.getMessage());
                    }

                    @Override
                    public void onNext(List<Repo> repoList) {
                        listener.onRepoListRetrievalSuccess(repoList);
                    }
                });
    }
}
