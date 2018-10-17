package com.bravin.shi.news.bean.pojo;

import java.sql.Date;

/**
 * created by bravin on 2018/10/17.
 */
public class User {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String username;
    private String phoneNumber;
    private String email;
    private int phoneVerified;
    private int emailVerified;
    private String realName;
    private String identityCardNumber;
    private int identityVerified;
    private String provinceName;
    private int provinceCode;
    private String cityName;
    private int cityCode;
    private String countyName;
    private int countyCode;
    private String signature;
    private String avatar;
    private String cover;
    private String mainColor;
    private int state;
    private int sex;
    private Date birthday;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneVerified() {
        return phoneVerified;
    }

    public void setPhoneVerified(int phoneVerified) {
        this.phoneVerified = phoneVerified;
    }

    public int getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(int emailVerified) {
        this.emailVerified = emailVerified;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdentityCardNumber() {
        return identityCardNumber;
    }

    public void setIdentityCardNumber(String identityCardNumber) {
        this.identityCardNumber = identityCardNumber;
    }

    public int getIdentityVerified() {
        return identityVerified;
    }

    public void setIdentityVerified(int identityVerified) {
        this.identityVerified = identityVerified;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public int getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(int provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getCityCode() {
        return cityCode;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public int getCountyCode() {
        return countyCode;
    }

    public void setCountyCode(int countyCode) {
        this.countyCode = countyCode;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getMainColor() {
        return mainColor;
    }

    public void setMainColor(String mainColor) {
        this.mainColor = mainColor;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", phoneVerified=" + phoneVerified +
                ", emailVerified=" + emailVerified +
                ", realName='" + realName + '\'' +
                ", identityCardNumber='" + identityCardNumber + '\'' +
                ", identityVerified=" + identityVerified +
                ", provinceName='" + provinceName + '\'' +
                ", provinceCode=" + provinceCode +
                ", cityName='" + cityName + '\'' +
                ", cityCode=" + cityCode +
                ", countyName='" + countyName + '\'' +
                ", countyCode=" + countyCode +
                ", signature='" + signature + '\'' +
                ", avatar='" + avatar + '\'' +
                ", cover='" + cover + '\'' +
                ", mainColor='" + mainColor + '\'' +
                ", state=" + state +
                ", sex=" + sex +
                ", birthday=" + birthday +
                '}';
    }
}
