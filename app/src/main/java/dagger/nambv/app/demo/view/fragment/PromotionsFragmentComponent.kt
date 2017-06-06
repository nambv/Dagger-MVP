package dagger.nambv.app.demo.view.fragment

import dagger.Subcomponent
import dagger.nambv.app.demo.di.scope.ActivityScope

@ActivityScope
@Subcomponent(modules = arrayOf(PromotionsFragmentModule::class))
interface PromotionsFragmentComponent {
    fun inject(promotionsFragment: PromotionsFragment)
}
