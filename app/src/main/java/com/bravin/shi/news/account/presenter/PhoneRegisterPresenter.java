package com.bravin.shi.news.account.presenter;

import com.bravin.btoast.BToast;
import com.bravin.shi.news.R;
import com.bravin.shi.news.account.ui.PhoneRegisterActivity;
import com.bravin.shi.news.base.interfas.impl.BasePresenter;
import com.bravin.shi.news.base.interfas.IBaseView;

import retrofit2.Retrofit;

/**
 * created by bravin on 2018/8/30.
 */
public class PhoneRegisterPresenter extends BasePresenter {
    private PhoneRegisterActivity view;

    public PhoneRegisterPresenter(PhoneRegisterActivity view) {
        this.view = view;
    }

    @Override
    public IBaseView getView() {
        return view;
    }

    @Override
    public void init() {

    }

    @Override
    public void onFinish() {

    }

    public void join(String verificationCode, String password) {
        BToast.success(view.getContext())
                .text("验证码: " + verificationCode + " 密码: " + password)
                .show();


    }
}
