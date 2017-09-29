package com.leaf.library.dagger;

import android.app.Activity;
import android.content.Context;

import com.leaf.library.dagger.annotation.ActivityScope;
import com.leaf.library.mvp.IMvpView;
import com.leaf.library.mvp.MvpActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ye on 2016/4/13.
 */
@Module
public class LfActivityModule {
    private final MvpActivity activity;

    public LfActivityModule(MvpActivity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    MvpActivity provideLfActivity() {
        return this.activity;
    }

    @Provides
    @ActivityScope
    Activity provideActivity() {
        return this.activity;
    }

    @Provides
    @ActivityScope
    Context provideContext() {
        return this.activity;
    }

    @Provides
    @ActivityScope
    protected IMvpView provideView() {
        return activity;
    }

}