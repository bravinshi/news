package com.bravin.shi.news.main.ui;

import com.bravin.shi.news.R;
import com.bravin.shi.news.base.SupportBKAndIBActivity;
import com.bravin.shi.news.base.interfas.IBasePresenter;
import com.bravin.shi.news.main.presenter.MainPresenter;

/**
 * created by bravin on 2018/8/30.
 */
public class MainActivity extends SupportBKAndIBActivity {

    private MainPresenter presenter;
    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onFinishInit() {
        presenter = new MainPresenter(this);
    }

    @Override
    public IBasePresenter getPresenter() {
        return presenter;
    }
}
