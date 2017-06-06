package dagger.nambv.app.demo.view.fragment;

import java.util.List;

import dagger.nambv.app.demo.model.Repo;

public interface PromotionsView {
    void showRepoList(List<Repo> values);
    void showError(final String errorMessage);
}
