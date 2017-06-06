package dagger.nambv.app.demo.di.module

import android.app.Application
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import dagger.nambv.app.demo.BaseApplication
import javax.inject.Singleton

@Module
class AppModule(var app: BaseApplication) {

    @Provides
    @Singleton
    fun provideApplication(): Application {
        return app
    }

    @Provides
    @Singleton
    fun provideResources(): Resources {
        return app.resources
    }
}
