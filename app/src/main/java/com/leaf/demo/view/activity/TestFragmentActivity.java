package com.leaf.demo.view.activity;

import android.os.Bundle;
import android.view.View;

import com.leaf.demo.R;
import com.leaf.demo.view.fragment.TestFragment;
import com.leaf.library.base.LfActivity;

public class TestFragmentActivity extends LfActivity {

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_fragment_contain;
    }

    @Override
    protected void doInject() {
    }

    @Override
    public void afterViewBind(View rootView, Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new TestFragment())
                    .commit();
        }
    }
}
