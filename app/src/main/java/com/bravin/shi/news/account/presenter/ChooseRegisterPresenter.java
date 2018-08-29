package com.bravin.shi.news.account.presenter;

import com.bravin.shi.news.account.ui.ChooseRegisterActivity;
import com.bravin.shi.news.base.BasePresenter;
import com.bravin.shi.news.base.interfas.IBaseView;

/**
 * created by bravin on 2018/8/17.
 */
public class ChooseRegisterPresenter extends BasePresenter {
    private ChooseRegisterActivity view;

    public ChooseRegisterPresenter(ChooseRegisterActivity view) {
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
}
