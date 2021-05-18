package com.prince.entity;

public class SC {
    private Integer cNo;

    private String sNo;

    private Integer score;

    public Integer getcNo() {
        return cNo;
    }

    public void setcNo(Integer cNo) {
        this.cNo = cNo;
    }

    public String getsNo() {
        return sNo;
    }

    public void setsNo(String sNo) {
        this.sNo = sNo == null ? null : sNo.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}