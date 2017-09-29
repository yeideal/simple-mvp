package com.leaf.demo.presenter;

import android.text.Editable;

import com.leaf.demo.model.ComputeManager;
import com.leaf.library.base.presenter.LfViewWithLifeCyclePresenter;
import com.leaf.library.mvp.IMvpView;

import javax.inject.Inject;

/**
 * Created by ye on 2017/9/29.
 */

public class TestPresenter extends LfViewWithLifeCyclePresenter<TestPresenter.ITestView> {
    @Inject
    ComputeManager manager;

    @Inject
    public TestPresenter(IMvpView iView) {
        super(iView);
    }

    public void compute(Editable text1, Editable text2) {
        String result = manager.compute(text1, text2);
        ITestView view = getView();
        view.showResult(result);

    }

    public interface ITestView extends IMvpView {
        /**
         * 显示结果
         */
        void showResult(String result);

    }
}
