package com.prince.entity;

import java.util.Date;

public class Teacher {
    private String tNo;

    private String tName;

    private String tPosition;

    private Date tBirthday;

    private Integer tSex;

    private String tPassword;

    public String gettNo() {
        return tNo;
    }

    public void settNo(String tNo) {
        this.tNo = tNo == null ? null : tNo.trim();
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName == null ? null : tName.trim();
    }

    public String gettPosition() {
        return tPosition;
    }

    public void settPosition(String tPosition) {
        this.tPosition = tPosition == null ? null : tPosition.trim();
    }

    public Date gettBirthday() {
        return tBirthday;
    }

    public void settBirthday(Date tBirthday) {
        this.tBirthday = tBirthday;
    }

    public Integer gettSex() {
        return tSex;
    }

    public void settSex(Integer tSex) {
        this.tSex = tSex;
    }

    public String gettPassword() {
        return tPassword;
    }

    public void settPassword(String tPassword) {
        this.tPassword = tPassword == null ? null : tPassword.trim();
    }
}