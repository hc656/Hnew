package com.example.hnew.mvp;

import android.os.Bundle;

import com.example.hnew.base.BaseActivity;
import com.example.hnew.base.BasePresenter;
import com.example.hnew.base.BaseView;

public abstract class MvpActivity<P extends BasePresenter> extends BaseActivity {
    protected P mPresent;

    @Override
    public void initBeforeView(Bundle savedInstanceState) {
        mPresent=createPresent();
        mPresent.attach((BaseView) this);
    }

    protected abstract P createPresent();

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresent.detach((BaseView) this);
    }

}