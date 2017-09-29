package com.leaf.demo.dagger;

import com.leaf.demo.view.fragment.TestFragment;
import com.leaf.library.dagger.LfFragmentModule;
import com.leaf.library.dagger.annotation.FragmentScope;

import dagger.Subcomponent;

/**
 * Created by ye on 2017/9/29.
 */
@FragmentScope
@Subcomponent(modules = {LfFragmentModule.class})
public interface DemoFragmentComponent {
    void plus(TestFragment testFragment);
}
