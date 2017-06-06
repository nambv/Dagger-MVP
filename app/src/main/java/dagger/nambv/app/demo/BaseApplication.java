package dagger.nambv.app.demo;

import android.app.Application;
import android.content.Context;

import dagger.nambv.app.demo.di.component.AppComponent;
import dagger.nambv.app.demo.di.component.DaggerAppComponent;
import dagger.nambv.app.demo.di.module.AppModule;

public class BaseApplication extends Application {

    private static AppComponent appComponent;
    private static BaseApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initAppComponents();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public static BaseApplication get(Context context) {
        return (BaseApplication) context.getApplicationContext();
    }

    @SuppressWarnings("deprecation")
    private void initAppComponents() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }
}
