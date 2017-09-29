package com.leaf.library.mvp;

/**
 * Created by ye on 2016/7/21.
 */

import android.content.Intent;
import android.os.Bundle;

import java.util.HashSet;
import java.util.Set;

/**
 * 基础视图代理类
 * Created by ye on 2016/4/8.
 */
public class MvpConnector {
    private Set<IMvpPresenter> presenterSet;
    private Set<ILifeCycle> lifeCycleSet;


    private MvpConnector() {
        presenterSet = new HashSet<>();
        lifeCycleSet = new HashSet<>();

    }

    public static MvpConnector newInstance() {
        return new MvpConnector();
    }

    public void savePresenter(IMvpPresenter presenter) {
        presenterSet.add(presenter);
        if (presenter instanceof ILifeCycle) {
            lifeCycleSet.add((ILifeCycle) presenter);
        }
    }

    public final void onCreate(Bundle savedInstanceState, Bundle extras) {
        for (ILifeCycle presenter : lifeCycleSet) {
            if (extras == null) {
                extras = new Bundle();
            }
            presenter.initParam(extras);
            presenter.onCreate(savedInstanceState, extras);
        }
    }

    public void onDestroy() {
        for (ILifeCycle presenter : lifeCycleSet) {
            presenter.onDestroy();
        }
        presenterSet.clear();
        lifeCycleSet.clear();
    }

    public void onResume() {
        for (ILifeCycle presenter : lifeCycleSet) {
            presenter.onResume();
        }
    }

    public void onPause() {
        for (ILifeCycle presenter : lifeCycleSet) {
            presenter.onPause();
        }
    }


    public void onSaveInstanceState(Bundle outState) {
        for (ILifeCycle presenter : lifeCycleSet) {
            presenter.onSaveInstanceState(outState);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        for (ILifeCycle presenter : lifeCycleSet) {
            presenter.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void onStart() {
        for (ILifeCycle presenter : lifeCycleSet) {
            presenter.onStart();
        }
    }

    public void onStop() {
        for (ILifeCycle presenter : lifeCycleSet) {
            presenter.onStop();
        }
    }

    public void onNewIntent(Intent intent) {
        for (ILifeCycle presenter : lifeCycleSet) {
            presenter.onNewIntent(intent);
        }
    }
}
