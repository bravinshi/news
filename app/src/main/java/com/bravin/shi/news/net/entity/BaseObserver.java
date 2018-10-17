package com.bravin.shi.news.net.entity;

import com.bravin.shi.news.constant.NetConstants;

import io.reactivex.observers.DefaultObserver;

public abstract class BaseObserver<T> extends DefaultObserver<BaseEntity<T>> {
    @Override
    public void onNext(BaseEntity<T> value) {
        com.orhanobut.logger.Logger.d(value);
        if (value.getCode() == NetConstants.SUCCESS) {
            onSuccess(value.getData());
        } else {
            onFail(new FailEntity(value.getCode(), value.getMessage()));
        }
        onComplete();
    }

    @Override
    public void onError(Throwable e) {
        com.orhanobut.logger.Logger.d(e);
        FailEntity failEntity = new FailEntity();
        failEntity.setCode(Integer.MAX_VALUE);
        failEntity.setMessage(e.getMessage());
        onFail(failEntity);
        onComplete();
    }

    @Override
    public void onComplete() {
    }

    public abstract void onSuccess(T t);

    public abstract void onFail(FailEntity entity);
}
