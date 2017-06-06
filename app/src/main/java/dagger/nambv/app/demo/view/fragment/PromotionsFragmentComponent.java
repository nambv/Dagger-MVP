package dagger.nambv.app.demo.view.fragment;

import dagger.Subcomponent;
import dagger.nambv.app.demo.di.scope.ActivityScope;

@ActivityScope
@Subcomponent(modules = {PromotionsFragmentModule.class})
public interface PromotionsFragmentComponent {
    void inject(PromotionsFragment promotionsFragment);
}
