package dagger.nambv.app.demo

import android.app.Application
import android.content.Context
import dagger.nambv.app.demo.di.component.AppComponent
import dagger.nambv.app.demo.di.component.DaggerAppComponent
import dagger.nambv.app.demo.di.module.AppModule

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        initAppComponents()
    }

    fun getAppComponent(): AppComponent {
        return appComponent
    }

    fun initAppComponents() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    companion object {

        lateinit var appComponent: AppComponent
        lateinit var instance: BaseApplication

        operator fun get(context: Context): BaseApplication {
            return context.applicationContext as BaseApplication
        }
    }
}
