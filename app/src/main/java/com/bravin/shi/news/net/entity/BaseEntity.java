package com.bravin.shi.news.net.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BaseEntity<T> implements Serializable {

    private static final long serialVersionUID = -3440061414071692254L;

    private int code;

    private String message;

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "code=" + code +
                ", message='" + message + '\'' +

                ", data=" + data +
                '}';
    }
}
