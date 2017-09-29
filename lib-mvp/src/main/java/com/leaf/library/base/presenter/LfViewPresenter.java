package com.leaf.library.base.presenter;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.leaf.library.IAct;
import com.leaf.library.exception.ViewNotBindException;
import com.leaf.library.mvp.IMvpView;
import com.leaf.library.mvp.MvpConnector;
import com.leaf.library.util.Logs;

import java.lang.ref.WeakReference;

/**
 * Created by ye on 2016/4/7.
 */
public abstract class LfViewPresenter<T extends IMvpView> extends LfSimplePresenter {
    protected WeakReference<T> referenceView;
    private IAct iAct;

    public LfViewPresenter(IMvpView iView) {
        try {
            referenceView = new WeakReference<T>((T) iView);
            MvpConnector connector = iView.getMvpConnector();
            connector.savePresenter(this);
        } catch (Throwable throwable) {
            Logs.e("referenceView 未实现接口", throwable);
        }
    }


    @Nullable
    protected T getView() {
        IMvpView iView;
        if (referenceView != null) {
            iView = referenceView.get();
        } else {
            iView = null;
        }
        if (iView == null) {
            throw new ViewNotBindException();
        }
        return (T) iView;
    }

    protected Context getContext() {
        if (iAct == null) {
            return null;
        }
        return iAct.getContext();
    }

    protected Activity getActivity() {
        if (iAct == null) {
            return null;
        }
        Context context = iAct.getContext();
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return null;
    }

    public ContentResolver getContentResolver() {
        return getActivity().getContentResolver();
    }

    protected FragmentActivity getFramentActivity() {
        Activity activity = getActivity();
        if (activity != null && activity instanceof FragmentActivity) {
            return (FragmentActivity) activity;
        }
        return null;
    }

    protected Intent getIntent() {
        Activity activity = getActivity();
        return activity.getIntent();
    }


    protected void setResult(int resultCode, Intent data) {
        getActivity().setResult(resultCode, data);
    }

    protected void finish() {
        Activity activity = getActivity();
        activity.finish();
    }

    protected FragmentManager getSupportFragmentManager() {
        FragmentActivity activity = getFramentActivity();
        if (activity != null) {
            return activity.getSupportFragmentManager();
        }
        return null;
    }

    protected void startActivity(Intent intent) {
        iAct.startActivity(intent);
    }

    protected void startActivityForResult(Intent intent, int requestCode) {
        iAct.startActivityForResult(intent, requestCode);
    }

}