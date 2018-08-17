package com.bravin.shi.news.base;

import android.content.Context;
import android.view.View;

import com.bravin.shi.news.base.interfas.impl.BaseActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * created by bravin on 2018/8/17.
 */
public abstract class SupportBKActivity extends BaseActivity {
    private Unbinder unbinder;

    @Override
    public void initView(Context context, View content) {
        unbinder = ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null)
            unbinder.unbind();
    }
}
