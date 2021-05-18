package com.prince.entity;

public class Course {
    private Integer cNo;

    private String tNo;

    private String cName;

    private String cType;

    private Integer cCredit;

    public Integer getcNo() {
        return cNo;
    }

    public void setcNo(Integer cNo) {
        this.cNo = cNo;
    }

    public String gettNo() {
        return tNo;
    }

    public void settNo(String tNo) {
        this.tNo = tNo == null ? null : tNo.trim();
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType == null ? null : cType.trim();
    }

    public Integer getcCredit() {
        return cCredit;
    }

    public void setcCredit(Integer cCredit) {
        this.cCredit = cCredit;
    }
}