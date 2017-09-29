package com.leaf.library.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.leaf.library.IDefineView;
import com.leaf.library.mvp.MvpActivity;
import com.leaf.library.util.UnifyViewManager;

import butterknife.ButterKnife;


/**
 * Created by ye on 2017/4/7.
 */

public abstract class LfActivity extends MvpActivity implements IDefineView {
    @Override
    protected void initAfterCreate(@Nullable Bundle savedInstanceState) {
        doInject();//doInject一定要放在最前面
        initParam(getParams(getIntent().getExtras()));
        if (this instanceof IDefineView) {
            UnifyViewManager.initView(this, this, savedInstanceState);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        initParam(getParams(intent));
    }


    private Bundle getParams(Intent intent) {
        Bundle params = intent.getExtras();
        if (params == null) {
            params = new Bundle();
        }
        return params;
    }

    private Bundle getParams(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        return bundle;
    }


    protected void initParam(Bundle params) {
    }

    /**
     * 依赖注入
     */
    protected void doInject() {

    }

    @Override
    public void beforeViewBind(View rootView) {

    }

    @Override
    public void afterViewBind(View rootView, Bundle savedInstanceState) {

    }

    @Override
    public void bindView(View rootView) {
        ButterKnife.bind(this, rootView);
    }
}
