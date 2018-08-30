package com.bravin.shi.news.account;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.bravin.shi.news.account.ui.PhoneRegisterActivity;

/**
 * created by bravin on 2018/8/30.
 */
public class AccountStarter {
    public static void startPhoneRegisterActivity(Context context, Bundle bundle) {
        Intent intent = new Intent(context, PhoneRegisterActivity.class);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        context.startActivity(intent);
    }
}
