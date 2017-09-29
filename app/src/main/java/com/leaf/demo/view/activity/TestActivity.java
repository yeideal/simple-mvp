package com.leaf.demo.view.activity;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.leaf.demo.R;
import com.leaf.demo.dagger.DemoDaggerHelper;
import com.leaf.demo.presenter.TestPresenter;
import com.leaf.library.base.LfActivity;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;

public class TestActivity extends LfActivity implements TestPresenter.ITestView {

    @Inject
    TestPresenter presenter;

    @Bind(R.id.numberEt2)
    EditText numberEt2;

    @Bind(R.id.numberEt1)
    EditText numberEt1;
    @Bind(R.id.resultText)
    TextView resultText;

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    protected void doInject() {
        DemoDaggerHelper.createActivityComponent(this).plus(this);
    }

    @OnClick(value = {R.id.goFragmentPageBtn, R.id.computeBtn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.computeBtn:
                presenter.compute(numberEt1.getText(), numberEt2.getText());
                break;

            case R.id.goFragmentPageBtn:
                startActivity(new Intent(this, TestFragmentActivity.class));
                break;
        }
    }

    @Override
    public void showResult(String result) {
        resultText.setText(result);
    }
}
