package com.bravin.shi.news.account.presenter;

import com.bravin.btoast.BToast;
import com.bravin.shi.news.account.ui.PhoneRegisterActivity;
import com.bravin.shi.news.base.interfas.IBaseView;
import com.bravin.shi.news.base.interfas.impl.BasePresenter;
import com.bravin.shi.news.bean.to.RegisterByPhoneTO;
import com.bravin.shi.news.net.NetworkManager;
import com.bravin.shi.news.net.entity.BaseEntity;
import com.bravin.shi.news.net.entity.BaseObserver;
import com.bravin.shi.news.net.entity.FailEntity;
import com.bravin.shi.news.net.service.IService;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;

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

    public void join(String phone, String verificationCode, String password) {
        Map requestParam = new HashMap(3);

        requestParam.put("phone", phone);
        requestParam.put("verificationCode", verificationCode);
        requestParam.put("password", password);

        Observable<BaseEntity<RegisterByPhoneTO>> observable =
                NetworkManager.create(IService.class).registerByPhone(requestParam);

        scheduleObservable(observable).subscribe(new BaseObserver<RegisterByPhoneTO>() {
            @Override
            public void onSuccess(RegisterByPhoneTO registerByPhoneTO) {
                BToast.success(getView().getContext())
                        .text("注册成功")
                        .show();
            }

            @Override
            public void onFail(FailEntity entity) {
                BToast.error(getView().getContext())
                        .text(entity.getMessage())
                        .show();
            }
        });

    }
}
