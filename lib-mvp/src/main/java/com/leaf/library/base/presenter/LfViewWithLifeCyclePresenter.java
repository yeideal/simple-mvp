package com.leaf.library.base.presenter;

import android.content.Intent;
import android.os.Bundle;

import com.leaf.library.mvp.ILifeCycle;
import com.leaf.library.mvp.IMvpView;


/**
 * Created by ye on 2016/4/7.
 */
public abstract class LfViewWithLifeCyclePresenter<T extends IMvpView> extends LfViewPresenter<T>
        implements ILifeCycle {
    public LfViewWithLifeCyclePresenter(IMvpView iView) {
        super(iView);
    }

    @Override
    public void onCreate(Bundle savedInstanceState, Bundle extras) {

    }

    @Override
    public void initParam(Bundle extras) {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onNewIntent(Intent intent) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

}
