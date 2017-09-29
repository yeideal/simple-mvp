package com.leaf.library.mvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


/**
 * @author Created by ye on 2016/4/7.
 */
public class MvpActivity extends AppCompatActivity implements IMvpView {
    private MvpConnector presenterConnector;

    @Override
    public final MvpConnector getMvpConnector() {
        if (presenterConnector == null) {
            synchronized (this) {
                if (presenterConnector == null) {
                    presenterConnector = MvpConnector.newInstance();
                }
            }
        }
        return presenterConnector;
    }

    @CallSuper
    @Override
    protected void onNewIntent(Intent intent) {
        getMvpConnector().onNewIntent(intent);
        super.onNewIntent(intent);
    }

    @CallSuper
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        getMvpConnector().onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onStart() {
        getMvpConnector().onStart();
        super.onStart();
    }

    @Override
    protected void onResume() {
        getMvpConnector().onResume();
        super.onResume();
    }

    @Override
    protected void onPause() {
        getMvpConnector().onPause();
        super.onPause();
    }

    @Override
    protected void onStop() {
        getMvpConnector().onStop();
        super.onStop();
    }

    @CallSuper
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        getMvpConnector().onSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initAfterCreate(savedInstanceState);
        Bundle params = getIntent().getExtras();
        if (params == null) {
            params = new Bundle();
        }
        getMvpConnector().onCreate(savedInstanceState, params);
    }

    @Override
    protected void onDestroy() {
        getMvpConnector().onDestroy();
        super.onDestroy();
    }


    protected void initAfterCreate(Bundle savedInstanceState) {
    }



}
