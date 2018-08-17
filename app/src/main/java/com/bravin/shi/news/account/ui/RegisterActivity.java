package com.bravin.shi.news.account.ui;

import com.bravin.shi.news.R;
import com.bravin.shi.news.account.presenter.RegisterPresenter;
import com.bravin.shi.news.base.interfas.IBasePresenter;
import com.bravin.shi.news.base.SupportBKActivity;
import com.gyf.barlibrary.ImmersionBar;

/**
 * created by bravin on 2018/8/17.
 */
public class RegisterActivity extends SupportBKActivity {
    private RegisterPresenter presenter;
    protected ImmersionBar immersionBar;

    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public void onFinishInit() {
        immersionBar = ImmersionBar.with(this)
                .statusBarColor("#00000000");
        immersionBar.init();

        presenter = new RegisterPresenter(this);
    }

    @Override
    public IBasePresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (immersionBar != null){
            immersionBar.destroy();
        }
    }
}
