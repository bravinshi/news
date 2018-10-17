package com.bravin.shi.news.account.ui;

import android.os.CountDownTimer;
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
import com.bravin.shi.news.custom.view.TransitionLayout;
import com.bravin.shi.news.util.StringUtils;
import com.gyf.barlibrary.ImmersionBar;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * created by bravin on 2018/8/29.
 */
public class PhoneRegisterActivity extends SupportBKAndIBActivity {

    private PhoneRegisterPresenter presenter;
    TextView getVerifyCode;

    EditText mEditPhone;

    TextView mTextRetrieve;

    TextView mTextJoin;

    TextView mTextPhoneNumber;

    EditText mEditVerificationCode;

    EditText mEditPassword;

    private boolean showFirstLayer = true;

    @BindView(R.id.tl_input_area)
    TransitionLayout mTransLayout;

    private final static int PHONE_NUMBER_LENGTH = 11;

    private CountDownTimer mTimer;

    private final int verificationCodeLength = 6;
    private final int passwordMinLength = 8;

    @Override
    public int getLayoutId() {
        return R.layout.activity_phone_register;
    }

    @Override
    public void onFinishInit() {
        immersionBar = ImmersionBar.with(this)
                .statusBarColor(R.color.statusBarColor);
        immersionBar.init();

        int[] layers = new int[]{R.layout.inner_register_input_phone_number,
                R.layout.inner_register_input_verification_code};

        mTransLayout.setLayers(layers);

        View layer1 = mTransLayout.getLayer(0);
        getVerifyCode = layer1.findViewById(R.id.tv_get_verify_code);
        getVerifyCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onGetVerificationCode(v);
            }
        });
        mEditPhone = layer1.findViewById(R.id.et_phone_number);

        View layer2 = mTransLayout.getLayer(1);
        mTextRetrieve = layer2.findViewById(R.id.tv_retrieve);
        mTextJoin = layer2.findViewById(R.id.tv_join);
        mTextPhoneNumber = layer2.findViewById(R.id.tv_phone_number);
        mEditVerificationCode = layer2.findViewById(R.id.rt_input_verification_code);
        mEditPassword = layer2.findViewById(R.id.rt_input_password);

        mTextRetrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRetrieve(v);
            }
        });

        mTextJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onJoin(v);
            }
        });

        initButtonStyle();

        presenter = new PhoneRegisterPresenter(this);
    }

    private void onRetrieve(View v) {
        // TODO 发送验证码
        BToast.success(getContext()).text(R.string.text_verification_code_has_retrieve).show();
        startCounting();
    }

    private void onJoin(View v) {
        String vc = mEditVerificationCode.getText().toString().trim();

        if (StringUtils.isTrimEmpty(vc)) {
            BToast.error(getContext()).text(R.string.hint_input_verification_code).show();
            return;
        }
        if (vc.length() < verificationCodeLength) {
            BToast.error(getContext()).text(R.string.text_verification_code_length_six).show();
            return;
        }
        String password = mEditPassword.getText().toString().trim();
        if (StringUtils.isTrimEmpty(password)) {
            BToast.error(getContext()).text(R.string.text_input_password).show();
            return;
        }
        if (password.length() < passwordMinLength) {
            BToast.error(getContext()).text(R.string.text_password_min_length_eight).show();
            return;
        }

        presenter.join(mTextPhoneNumber.getText().toString(), vc, password);
    }

    private void onGetVerificationCode(View v) {
        String phone = mEditPhone.getText().toString();
        // 检测手机号格式
        if (!StringUtils.isPhoneNumber(phone)) {
            BToast.error(getContext()).text(R.string.hint_input_right_phone_format).show();
            return;
        }
        // TODO 发送验证码


        showFirstLayer = false;
        mTextPhoneNumber.setText(phone);
        startCounting();
        mTransLayout.showLayer(1);
        // 弹出输入法
        mTransLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
               showSoftInput(mEditVerificationCode);
            }
        }, mTransLayout.getDuration());
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
                if (s.length() == PHONE_NUMBER_LENGTH) {
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

    private void startCounting() {
        mTextRetrieve.setEnabled(false);
        mTextRetrieve.setTextColor(PhoneRegisterActivity.this.
                getResources().getColor(R.color.notEnable));
        if (mTimer == null) {
            mTimer = new CountDownTimer(60 * 1000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    int remainingTime = (int) (millisUntilFinished / 1000);
                    String hint = PhoneRegisterActivity.this.getString(R.string.text_retrieve) +
                            "(" + remainingTime + ")";
                    mTextRetrieve.setText(hint);
                }

                @Override
                public void onFinish() {
                    mTextRetrieve.setEnabled(true);
                    mTextRetrieve.setText(PhoneRegisterActivity.this.
                            getString(R.string.text_retrieve));
                    mTextRetrieve.setTextColor(PhoneRegisterActivity.this.
                            getResources().getColor(R.color.center));
                }
            };
        }

        mTimer.start();
    }

    @OnClick(R.id.view_back)
    public void onBack() {
        if (showFirstLayer) {
            finish();
        } else {
            mTransLayout.showLayer(0);
            showFirstLayer = true;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
        }
    }
}
