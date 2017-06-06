package dagger.nambv.app.demo.presenter;

import java.util.List;

import dagger.nambv.app.demo.model.Repo;

public interface OnPromotionsCompletedListener {
    void onRepoListRetrievalSuccess(List<Repo> data);
    void onRepoListRetrievalFailure(String errorMessage);
}
