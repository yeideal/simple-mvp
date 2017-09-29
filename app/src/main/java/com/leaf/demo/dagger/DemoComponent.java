package com.leaf.demo.dagger;


import com.leaf.library.dagger.LfActivityModule;
import com.leaf.library.dagger.LfFragmentModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ye on 2017/4/1.
 */
@Singleton
@Component(modules = {DemoModule.class})
public interface DemoComponent {
    DemoActivityComponent plus(LfActivityModule activityModule);

    DemoFragmentComponent plus(LfFragmentModule lfFragmentModule);
}
