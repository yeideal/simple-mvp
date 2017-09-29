package com.leaf.library.util;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leaf.library.IDefineView;

/**
 * Created by ye on 2017/3/31.
 */
public class UnifyViewManager {


    public static View initView(Context context, IDefineView unifyView, Bundle savedInstanceState) {
        View rootView = null;
        int rootLayoutId = unifyView.getRootLayoutId();
        if (rootLayoutId > 0) {
            if (unifyView instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) unifyView;
                ViewGroup.inflate(context, rootLayoutId, viewGroup);
                rootView = viewGroup;
            } else {
                rootView = inflateView(context, rootLayoutId);
                if (unifyView instanceof Activity) {
                    Activity activity = (Activity) unifyView;
                    activity.setContentView(rootView);
                } else if (unifyView instanceof IUnifyViewContent) {
                    IUnifyViewContent IUnifyViewContent = (IUnifyViewContent) unifyView;
                    IUnifyViewContent.setContentView(rootView);
                }
            }
        } else if (unifyView instanceof IViewMaker) {
            IViewMaker viewMaker = (IViewMaker) unifyView;
            rootView = viewMaker.makeView(rootLayoutId);
        }

        if (rootView != null) {
            unifyView.beforeViewBind(rootView);
            unifyView.bindView(rootView);
            unifyView.afterViewBind(rootView, savedInstanceState);
            return rootView;
        }
        Logs.d("layout id not defined");
        return null;
    }

    public static View inflateView(Context context, int rootLayoutId) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View rootView = layoutInflater.inflate(rootLayoutId, null, false);
        return rootView;
    }


    public interface IUnifyViewContent {
        void setContentView(View view);
    }

    public interface IViewMaker {
        View makeView(int viewId);
    }

}
