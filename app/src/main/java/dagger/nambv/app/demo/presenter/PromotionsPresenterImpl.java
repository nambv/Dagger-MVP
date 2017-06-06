package dagger.nambv.app.demo.presenter;

import java.util.List;

import javax.inject.Inject;

import dagger.nambv.app.demo.interactor.MainInteractor;
import dagger.nambv.app.demo.model.Repo;
import dagger.nambv.app.demo.view.fragment.PromotionsView;

public class PromotionsPresenterImpl implements PromotionsPresenter, OnPromotionsCompletedListener {

    private PromotionsView view;
    private MainInteractor mainInteractor;

    @Inject
    public PromotionsPresenterImpl(PromotionsView view, MainInteractor mainInteractor) {
        this.view = view;
        this.mainInteractor = mainInteractor;
    }

    @Override
    public void requestRepoList(String userName) {
        mainInteractor.getRepoList(userName, this);
    }

    @Override
    public void onRepoListRetrievalSuccess(List<Repo> data) {
        view.showRepoList(data);
    }

    @Override
    public void onRepoListRetrievalFailure(String errorMessage) {
        view.showError(errorMessage);
    }
}
