package com.bravin.shi.news;

import android.app.Application;

import com.bravin.btoast.BToast;
import com.bravin.shi.news.util.Utils;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;

/**
 * created by bravin on 2018/8/10.
 */
public class NewsApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        if (LeakCanary.isInAnalyzerProcess(this)) {//1
//            // This process is dedicated to LeakCanary for heap analysis.
//            // You should not init your app in this process.
//            return;
//        }
//        LeakCanary.install(this);
        // BToast
        BToast.Config.getInstance().apply(this);
        // Logger
        Logger.addLogAdapter(new AndroidLogAdapter());
        //Utils
        Utils.init(this);


    }
}
