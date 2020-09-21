package com.licw.springbootstudentmanage.beans;

import java.io.Serializable;

public class User implements Serializable {
    private String userName;
    private String passWd;

    public User(String userName, String passWd) {
        this.userName = userName;
        this.passWd = passWd;
    }

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWd() {
        return passWd;
    }

    public void setPassWd(String passWd) {
        this.passWd = passWd;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", passWd='" + passWd + '\'' +
                '}';
    }
}
