package com.leaf.library.dagger;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * 全局的类实例
 * Created by ye on 2016/4/13.
 */
@Module
public class LfAppModule {
    private final Application app;

    public LfAppModule(Application app) {
        this.app = app;
    }

    @Provides
    @Singleton
    protected Application provideLfApplication() {
        return app;
    }

    @Provides
    @Singleton
    protected Context provideContext() {
        return app.getApplicationContext();
    }

    @Provides
    @Singleton
    protected AssetManager provideAssetManager() {
        return app.getAssets();
    }
}
