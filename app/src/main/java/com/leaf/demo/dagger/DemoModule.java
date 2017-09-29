package com.leaf.demo.dagger;

import com.leaf.demo.model.ComputeManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ye on 2017/9/29.
 */
@Module
public class DemoModule {

    @Singleton
    @Provides
    public ComputeManager provideComputeManager() {
        return new ComputeManager();
    }
}
