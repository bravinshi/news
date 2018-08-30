package com.bravin.shi.news.account.ui;

import android.view.View;
import android.widget.TextView;

import com.bravin.shi.news.R;
import com.bravin.shi.news.account.AccountStarter;
import com.bravin.shi.news.account.presenter.ChooseRegisterPresenter;
import com.bravin.shi.news.base.interfas.IBasePresenter;
import com.bravin.shi.news.base.SupportBKAndIBActivity;
import com.gyf.barlibrary.ImmersionBar;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * created by bravin on 2018/8/17.
 */
public class ChooseRegisterActivity extends SupportBKAndIBActivity {
    private ChooseRegisterPresenter presenter;

    @BindView(R.id.tv_register)
    TextView mTextRegister;

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

    @OnClick({R.id.tv_register, R.id.iv_vx, R.id.iv_qq, R.id.iv_vb})
    public void onRegister(View v) {
        if (v.getId() == R.id.tv_register){
            AccountStarter.startPhoneRegisterActivity(v.getContext(), null);
        }
    }
}
