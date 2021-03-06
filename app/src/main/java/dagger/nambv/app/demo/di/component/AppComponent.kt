package dagger.nambv.app.demo.di.component

import dagger.Component
import dagger.nambv.app.demo.di.module.AppModule
import dagger.nambv.app.demo.di.module.CommonModule
import dagger.nambv.app.demo.view.fragment.PromotionsFragmentComponent
import dagger.nambv.app.demo.view.fragment.PromotionsFragmentModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, CommonModule::class))
interface AppComponent {
    operator fun plus(module: PromotionsFragmentModule): PromotionsFragmentComponent
}
