package dagger.nambv.app.demo.di.module;

import android.app.Application;
import android.content.res.Resources;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.nambv.app.demo.BaseApplication;

@Module
public class AppModule {
    BaseApplication app;

    public AppModule(BaseApplication app) {
        this.app = app;
    }

    @Provides
    @Singleton
    Application provideApplication() { return app; }

    @Provides
    @Singleton
    Resources provideResources() {
        return app.getResources();
    }
}
