package com.bravin.shi.news.base.interfas.impl;

import android.widget.Toast;

import com.bravin.btoast.BToast;
import com.bravin.shi.news.R;
import com.bravin.shi.news.base.interfas.IBasePresenter;
import com.bravin.shi.news.util.NetworkUtils;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * created by bravin on 2018/6/7.
 */
public abstract class BasePresenter implements IBasePresenter {

    public void toast(CharSequence text, int duration) {
        BToast.normal(getView().getContext())
                .text(text)
                .duration(duration)
                .show();
    }

    public void toast(int textRes, int duration) {
        BToast.normal(getView().getContext())
                .text(textRes)
                .duration(duration)
                .show();
    }

    public void toast(CharSequence text) {
        BToast.normal(getView().getContext())
                .text(text)
                .show();
    }

    public void toast(int textRes) {
        BToast.normal(getView().getContext())
                .text(textRes)
                .show();
    }

    public void onResume() {

    }

    /**
     * 访问失败后自动重试次数
     */
    private static final int RETRY_TIMES = 1;

    /**
     * 约束网络访问流程
     *
     * @param observable 需要约束的{@link Observable}
     * @param <T>        保证参数一致性
     * @return {@ling Observable}
     */
    public <T> Observable<T> scheduleObservable(final Observable<T> observable) {
        return observable.retry(RETRY_TIMES)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) {
                        if (!NetworkUtils.isConnected()) {
                            disposable.dispose();// 阻断事件流
                            toast(R.string.hint_no_network, Toast.LENGTH_SHORT);
                        }
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                // RxLifeCycle 处理 更好的处理方案  AutoDispose
                .compose(getView().getLifecycleProvider().<T>bindToLifecycle())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 约束网络访问流程
     *
     * @param retryTime  重试次数
     * @param observable 需要约束的
     * @param <T>        保证参数一致性
     * @return {@link Observable}
     */
    public <T> Observable<T> scheduleObservable(int retryTime, Observable<T> observable) {
        return observable.retry(retryTime)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) {
                        if (!NetworkUtils.isConnected()) {
                            disposable.dispose();// 阻断事件流
                            toast(R.string.hint_no_network, Toast.LENGTH_SHORT);
                        }
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                // RxLifeCycle 处理 更好的处理方案  AutoDispose
                .compose(getView().getLifecycleProvider().<T>bindToLifecycle())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
