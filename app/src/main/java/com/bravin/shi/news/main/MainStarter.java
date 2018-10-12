package com.bravin.shi.news.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.bravin.shi.news.main.ui.MainActivity;

/**
 * created by bravin on 2018/10/11.
 */
public class MainStarter {
    public static void startMainActivity(Context context, Bundle bundle) {
        Intent intent = new Intent(context, MainActivity.class);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        context.startActivity(intent);
    }
}
