package com.bravin.shi.news.bean.to;

import com.bravin.shi.news.bean.pojo.User;

/**
 * created by bravin on 2018/10/17.
 */
public class RegisterByPhoneTO {
    private String sessionToken;
    private User user;

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "RegisterByPhoneTO{" +
                "sessionToken='" + sessionToken + '\'' +
                ", user=" + user +
                '}';
    }
}
