package com.bravin.shi.news.base.interfas.impl;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bravin.shi.news.R;
import com.bravin.shi.news.base.interfas.IBaseView;
import com.bravin.shi.news.util.KeyboardUtils;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;


/**
 * created by bravin on 2018/5/20.
 */
public abstract class BaseActivity extends RxAppCompatActivity implements IBaseView {
    private Dialog loadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        beforeSetContentView();
        setContentView(R.layout.activity_base);
        if (getLayoutId() != 0) {
            LayoutInflater.from(this).inflate(getLayoutId(), (ViewGroup) findViewById(R.id.container), true);
        }
        initView(this, getWindow().getDecorView());
        onFinishInit();
        if (getPresenter() != null) getPresenter().init();
    }

    public void showSoftInput(View view) {
        KeyboardUtils.showSoftInput(view);
    }

    public void showSoftInput() {
        KeyboardUtils.showSoftInput(BaseActivity.this);
    }

    @Override
    public LifecycleProvider getLifecycleProvider() {
        return BaseActivity.this;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (getPresenter() != null) getPresenter().onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        KeyboardUtils.hideSoftInput(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        dismissLoading();
        if (getPresenter() != null) getPresenter().onFinish();
    }

    public abstract int getLayoutId();

    public abstract void initView(Context context, View content);

    public abstract void onFinishInit();

    @Override
    public Context getContext() {
        return BaseActivity.this;
    }

    /**
     * 用于在onCreate中setContentView前调用
     * 在BaseActivity中默认实现以屏蔽子类必须实现
     * 如有需要 请重写该方法
     */
    public void beforeSetContentView() {
    }

    public void showLoading() {
        if (loadingDialog == null) {
            ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("加载中...");
            progressDialog.setIndeterminate(false);
            loadingDialog = progressDialog;
        }
        if (!loadingDialog.isShowing()) {
            loadingDialog.show();
        }
    }

    public void dismissLoading() {
        if (loadingDialog != null && loadingDialog.isShowing())
            loadingDialog.dismiss();
    }
}
