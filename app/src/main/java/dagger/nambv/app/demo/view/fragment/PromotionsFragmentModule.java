package dagger.nambv.app.demo.view.fragment;

import dagger.Module;
import dagger.Provides;
import dagger.nambv.app.demo.di.scope.ActivityScope;
import dagger.nambv.app.demo.interactor.MainInteractor;
import dagger.nambv.app.demo.interactor.MainInteractorImpl;
import dagger.nambv.app.demo.presenter.PromotionsPresenter;
import dagger.nambv.app.demo.presenter.PromotionsPresenterImpl;

@Module
public class PromotionsFragmentModule {

    private PromotionsView view;

    public PromotionsFragmentModule(PromotionsView view) {
        this.view = view;
    }

    @Provides
    @ActivityScope
    PromotionsView providePromotionsView() {
        return this.view;
    }

    @Provides
    @ActivityScope
    MainInteractor provideMainInteractor(MainInteractorImpl interactor) {
        return interactor;
    }

    @Provides
    @ActivityScope
    PromotionsPresenter providePromotionsPresenter(PromotionsPresenterImpl presenter) {
        return presenter;
    }
}
