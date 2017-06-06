package dagger.nambv.app.demo.view.fragment

import dagger.Module
import dagger.Provides
import dagger.nambv.app.demo.di.scope.ActivityScope
import dagger.nambv.app.demo.interactor.MainInteractor
import dagger.nambv.app.demo.interactor.MainInteractorImpl
import dagger.nambv.app.demo.presenter.PromotionsPresenter
import dagger.nambv.app.demo.presenter.PromotionsPresenterImpl

@Module
class PromotionsFragmentModule {

    val view: PromotionsView

    constructor(view: PromotionsView) {
        this.view = view
    }

    @Provides
    @ActivityScope
    fun providePromotionsView(): PromotionsView {
        return this.view
    }

    @Provides
    @ActivityScope
    fun provideMainInteractor(interactor: MainInteractorImpl): MainInteractor {
        return interactor
    }

    @Provides
    @ActivityScope
    fun providePromotionsPresenter(presenter: PromotionsPresenterImpl): PromotionsPresenter {
        return presenter
    }
}
