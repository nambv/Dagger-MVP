package dagger.nambv.app.demo.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import dagger.nambv.app.demo.BaseApplication;
import dagger.nambv.app.demo.R;
import dagger.nambv.app.demo.model.Repo;
import dagger.nambv.app.demo.presenter.PromotionsPresenter;
import dagger.nambv.app.demo.util.CommonConstants;
import dagger.nambv.app.demo.util.CommonUtils;

public class PromotionsFragment extends Fragment implements PromotionsView {

    @Inject
    PromotionsPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_promotions, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initializeFragment(savedInstanceState);
    }

    private void initializeFragment(Bundle savedInstanceState) {
        BaseApplication.get(this.getContext())
                .getAppComponent()
                .plus(new PromotionsFragmentModule(this))
                .inject(this);

        presenter.requestRepoList(CommonConstants.DEFAULT_USER_NAME);
    }

    @Override
    public void showRepoList(List<Repo> values) {
        Log.w("TAG", String.valueOf(values.size()));
    }

    @Override
    public void showError(String errorMessage) {
        CommonUtils.showToastMessage(this.getActivity(), errorMessage);
    }
}
