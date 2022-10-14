package com.cdcompany.entity;

public class User {

    private String userPhone;
    private String userPwd;


    public User(String userPhone, String userPwd) {
        this.userPhone = userPhone;
        this.userPwd = userPwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "userPhone='" + userPhone + '\'' +
                ", userPwd='" + userPwd + '\'' +
                '}';
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
}
