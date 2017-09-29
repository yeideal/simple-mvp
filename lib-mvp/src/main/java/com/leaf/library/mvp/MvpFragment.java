package com.leaf.library.mvp;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ye on 2016/4/7.
 */
public abstract class MvpFragment extends Fragment implements IMvpFragment {
    private MvpConnector presenterConnector;

    @Override
    public Fragment getFragment() {
        return this;
    }

    public final MvpConnector getMvpConnector() {
        if (presenterConnector == null) {
            presenterConnector = MvpConnector.newInstance();
        }
        return presenterConnector;
    }


    @Nullable
    @Override
    public final View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = initView(inflater, container, savedInstanceState);
        getMvpConnector().onCreate(savedInstanceState, getArguments());
        return view;
    }

    public abstract View initView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);

    @Override
    public void onDestroyView() {
        getMvpConnector().onDestroy();
        super.onDestroyView();
    }

    @CallSuper
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        getMvpConnector().onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getMvpConnector().onSaveInstanceState(outState);

    }

    @Override
    public void onResume() {
        super.onResume();
        getMvpConnector().onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        getMvpConnector().onPause();
    }

    @Override
    public void onStart() {
        super.onStart();
        getMvpConnector().onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        getMvpConnector().onStop();
    }

}
