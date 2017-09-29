package com.leaf.demo.dagger;


import com.leaf.demo.view.activity.TestActivity;
import com.leaf.library.dagger.LfActivityModule;
import com.leaf.library.dagger.annotation.ActivityScope;

import dagger.Subcomponent;

/**
 * Created by ye on 2017/4/1.
 */
@ActivityScope
@Subcomponent(modules = {LfActivityModule.class})
public interface DemoActivityComponent {
    void plus(TestActivity testActivity);


}
