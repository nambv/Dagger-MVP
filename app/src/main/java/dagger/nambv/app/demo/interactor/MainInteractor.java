package dagger.nambv.app.demo.interactor;

import dagger.nambv.app.demo.presenter.OnPromotionsCompletedListener;

public interface MainInteractor {
    void getRepoList(String userName, final OnPromotionsCompletedListener listener);
}
