package com.leaf.library.dagger;


import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.leaf.library.dagger.annotation.FragmentScope;
import com.leaf.library.mvp.IMvpFragment;
import com.leaf.library.mvp.IMvpView;
import com.leaf.library.mvp.MvpActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ye on 2016/4/14.
 */
@Module
public class LfFragmentModule {
    private IMvpFragment iFragment;

    public LfFragmentModule(IMvpFragment iFragment) {
        this.iFragment = iFragment;
    }

    @Provides
    @FragmentScope
    Fragment provideFragment() {
        return iFragment.getFragment();
    }

    @Provides
    @FragmentScope
    Activity provideActivity() {
        return iFragment.getFragment().getActivity();
    }

    @Provides
    @FragmentScope
    MvpActivity provideBaseActivity(Activity activity) {
        return (MvpActivity) activity;
    }

    @Provides
    @FragmentScope
    Context provideContext(Activity activity) {
        return activity;
    }

    @Provides
    @FragmentScope
    protected IMvpView provideView() {
        return iFragment;
    }
}
