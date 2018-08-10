package com.bravin.shi.news;

import android.app.Application;

import com.bravin.btoast.BToast;
import com.bravin.shi.news.util.Utils;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * created by bravin on 2018/8/10.
 */
public class NewsApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // BToast
        BToast.Config.getInstance().apply(this);
        // Logger
        Logger.addLogAdapter(new AndroidLogAdapter());
        //Utils
        Utils.init(this);
    }
}
