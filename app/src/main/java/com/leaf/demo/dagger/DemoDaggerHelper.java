package com.leaf.demo.dagger;


import com.leaf.library.base.LfActivity;
import com.leaf.library.base.LfFragment;
import com.leaf.library.dagger.LfActivityModule;
import com.leaf.library.dagger.LfFragmentModule;

/**
 * Created by ye on 2017/4/1.
 */

public class DemoDaggerHelper {
    private static DemoComponent demoComponent;

    public static DemoComponent getDemoComponent() {
        if (demoComponent == null) {
            demoComponent = DaggerDemoComponent.builder().build();
        }
        return demoComponent;
    }

    public static DemoActivityComponent createActivityComponent(LfActivity activity) {
        DemoActivityComponent homeActivityComponent = getDemoComponent().plus(new LfActivityModule(activity));
        return homeActivityComponent;
    }

    public static DemoFragmentComponent createFragmentComponent(LfFragment fragment) {
       DemoFragmentComponent homeFragmentComponent = getDemoComponent().plus(new LfFragmentModule(fragment));
        return homeFragmentComponent;
    }
}
