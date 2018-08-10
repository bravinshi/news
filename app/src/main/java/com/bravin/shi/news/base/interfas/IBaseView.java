package com.bravin.shi.news.base.interfas;

import android.content.Context;

import com.trello.rxlifecycle2.LifecycleProvider;

/**
 * created by bravin on 2018/8/10.
 */
public interface IBaseView {
    // 获取presenter
    IBasePresenter getPresenter();

    Context getContext();

    // 获取LifecycleProvider 对RxLifeCycle在Presenter中的实现提供支撑
    <T> LifecycleProvider<T> getLifecycleProvider();
}
