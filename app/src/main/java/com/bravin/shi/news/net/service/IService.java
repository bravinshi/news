package com.bravin.shi.news.net.service;

import com.bravin.shi.news.bean.to.RegisterByPhoneTO;
import com.bravin.shi.news.net.entity.BaseEntity;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * created by bravin on 2018/10/11.
 */
public interface IService {
    // 根据手机号注册账号
    @POST("/user/register/phone")
    Observable<BaseEntity<RegisterByPhoneTO>> registerByPhone(@Body Map<String, String> map);
}
