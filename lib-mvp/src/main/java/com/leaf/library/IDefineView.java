package com.leaf.library;

import android.os.Bundle;
import android.view.View;

/**
 * 统一试图接口
 * Created by ye on 2017/3/31.
 */
public interface IDefineView {
    /**
     * 取得布局
     *
     * @return
     */
    int getRootLayoutId();
    /**
     * 视图绑定前触发
     *
     * @param rootView
     */
    void beforeViewBind(View rootView);

    /**
     * 视图绑定之后触发
     *
     * @param savedInstanceState
     */
    void afterViewBind(View rootView, Bundle savedInstanceState);

    /**
     * 绑定view
     *
     * @param rootView
     */
    void bindView(View rootView);
}
