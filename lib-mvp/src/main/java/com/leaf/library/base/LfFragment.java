package com.leaf.library.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leaf.library.IDefineView;
import com.leaf.library.mvp.MvpFragment;
import com.leaf.library.util.UnifyViewManager;

import butterknife.ButterKnife;

/**
 * Created by ye on 2017/4/7.
 */

public abstract class LfFragment extends MvpFragment implements IDefineView {
    private View rootView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EventHelper.register(this);
        doInject();
        initParam_();
    }

    @Nullable
    @Override
    public View initView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null || !initOnce()) {//需要多次初始化，或视图为空
            if (this instanceof IDefineView) {
                rootView = UnifyViewManager.initView(getContext(), this, savedInstanceState);
            }
        }
        return rootView;
    }

    /**
     * 依赖注入
     */
    protected void doInject() {

    }

    /**
     * 是否只是初始化一次视图
     *
     * @return
     */
    protected boolean initOnce() {
        return true;
    }

    /**
     * rootview
     *
     * @return
     */
    protected final View getRootView() {
        return rootView;
    }

    public final Fragment getFragment() {
        return this;
    }

    private void initParam_() {
        Bundle params = getArguments();
        if (params == null) {
            params = new Bundle();
        }
        initParam(params);
    }

    protected void initParam(Bundle params) {
    }


    @Override
    public void onPause() {
        super.onPause();
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
