package com.bravin.shi.news.account.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.bravin.btoast.BToast;
import com.bravin.shi.news.R;
import com.bravin.shi.news.account.presenter.PhoneRegisterPresenter;
import com.bravin.shi.news.base.SupportBKAndIBActivity;
import com.bravin.shi.news.base.interfas.IBasePresenter;
import com.bravin.shi.news.util.StringUtils;
import com.gyf.barlibrary.ImmersionBar;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * created by bravin on 2018/8/29.
 */
public class PhoneRegisterActivity extends SupportBKAndIBActivity {

    private PhoneRegisterPresenter presenter;
    @BindView(R.id.tv_get_verify_code)
    TextView getVerifyCode;

    @BindView(R.id.et_phone_number)
    EditText mEditPhone;

    private final int PHONE_NUMBER_LENGTH = 11;

    @Override
    public int getLayoutId() {
        return R.layout.activity_phone_register;
    }

    @Override
    public void onFinishInit() {
        immersionBar = ImmersionBar.with(this)
                .statusBarColor("#00000000");
        immersionBar.init();

        initButtonStyle();

        presenter = new PhoneRegisterPresenter(this);
    }

    @OnClick(R.id.tv_get_verify_code)
    public void onGetVerificationCode(View v) {
        String phone = mEditPhone.getText().toString();
        // 检测手机号格式
        if (!StringUtils.isPhoneNumber(phone)) {
            BToast.error(getContext()).text(R.string.hint_input_right_phone_format).show();
            return;
        }

        // TODO 发送验证码

    }

    @Override
    public IBasePresenter getPresenter() {
        return presenter;
    }

    @Override

    protected void onResume() {
        super.onResume();
        // 如果没有输入11位手机号 自动弹出输入法
        if (mEditPhone.getText().toString().trim().length() != PHONE_NUMBER_LENGTH) {
            mEditPhone.postDelayed(new Runnable() {
                @Override
                public void run() {
                    showSoftInput(mEditPhone);
                }
            }, 200);
        }
    }

    private void initButtonStyle() {
        getVerifyCode.setEnabled(false);

        mEditPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 11) {
                    getVerifyCode.setEnabled(true);
                } else {
                    getVerifyCode.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
