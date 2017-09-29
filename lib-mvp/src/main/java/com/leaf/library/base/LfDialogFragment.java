package com.leaf.library.base;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leaf.library.IDefineView;
import com.leaf.library.mvp.IMvpFragment;
import com.leaf.library.mvp.MvpDialogFragment;
import com.leaf.library.util.UnifyViewManager;

import butterknife.ButterKnife;

/**
 * Created by ye on 2017/4/14.
 */

public abstract class LfDialogFragment extends MvpDialogFragment
        implements IDefineView, IMvpFragment {

    private View rootView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        doInject();
        getMvpConnector().onCreate(savedInstanceState, args == null ? new Bundle() : args);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null || !initOnce()) {//需要多次初始化，或视图为空
            if (this instanceof IDefineView) {
                rootView = UnifyViewManager.initView(getContext(), (IDefineView) this, savedInstanceState);
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

    protected final View getRootView() {
        return rootView;
    }

    public final Fragment getFragment() {
        return this;
    }


    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialog);
        }
    }

    public void cancel() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.cancel();
        }
    }

    private DialogInterface.OnCancelListener onCancelListener;

    public void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        this.onCancelListener = onCancelListener;
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
