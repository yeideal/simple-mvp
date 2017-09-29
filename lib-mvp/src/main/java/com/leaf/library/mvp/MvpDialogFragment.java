package com.leaf.library.mvp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

/**
 * Created by ye on 2016/4/7.
 */
public class MvpDialogFragment extends DialogFragment implements IMvpView {
    private MvpConnector presenterConnector;

    @Override
    public final MvpConnector getMvpConnector() {
        if (presenterConnector == null) {
            presenterConnector = MvpConnector.newInstance();
        }
        return presenterConnector;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getMvpConnector().onDestroy();
    }

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
