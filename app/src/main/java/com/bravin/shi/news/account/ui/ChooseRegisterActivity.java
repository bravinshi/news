package com.bravin.shi.news.account.ui;

import com.bravin.shi.news.R;
import com.bravin.shi.news.account.presenter.ChooseRegisterPresenter;
import com.bravin.shi.news.base.interfas.IBasePresenter;
import com.bravin.shi.news.base.SupportBKActivity;
import com.gyf.barlibrary.ImmersionBar;

/**
 * created by bravin on 2018/8/17.
 */
public class ChooseRegisterActivity extends SupportBKActivity {
    private ChooseRegisterPresenter presenter;
    protected ImmersionBar immersionBar;

    @Override
    public int getLayoutId() {
        return R.layout.activity_choose_register;
    }

    @Override
    public void onFinishInit() {
        immersionBar = ImmersionBar.with(this)
                .statusBarColor("#00000000");
        immersionBar.init();

        presenter = new ChooseRegisterPresenter(this);
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
