package com.prince.entity;

public class Admin {
    private String aNo;

    private String aPassword;

    public String getaNo() {
        return aNo;
    }

    public void setaNo(String aNo) {
        this.aNo = aNo == null ? null : aNo.trim();
    }

    public String getaPassword() {
        return aPassword;
    }

    public void setaPassword(String aPassword) {
        this.aPassword = aPassword == null ? null : aPassword.trim();
    }
}