package com.prince.entity;

import java.util.Date;

public class Student {
    private String sNo;

    private String sName;

    private Date sBirthday;

    private Integer sSex;

    private String sPassword;

    public String getsNo() {
        return sNo;
    }

    public void setsNo(String sNo) {
        this.sNo = sNo == null ? null : sNo.trim();
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName == null ? null : sName.trim();
    }

    public Date getsBirthday() {
        return sBirthday;
    }

    public void setsBirthday(Date sBirthday) {
        this.sBirthday = sBirthday;
    }

    public Integer getsSex() {
        return sSex;
    }

    public void setsSex(Integer sSex) {
        this.sSex = sSex;
    }

    public String getsPassword() {
        return sPassword;
    }

    public void setsPassword(String sPassword) {
        this.sPassword = sPassword == null ? null : sPassword.trim();
    }
}