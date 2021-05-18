/**
 * @AUTHOR Prince
 * @TIME 2021/5/17 21:59
 */

package com.prince.entity;

public class Score {
    private String sNo;
    private String sName;
    private Integer cNo;
    private String cName;
    private String cType;
    private Integer cCredit;
    private Integer score;
    private String tNo;
    private String tName;

    public String getsNo() {
        return sNo;
    }

    @Override
    public String toString() {
        return "Score{" +
                "sNo='" + sNo + '\'' +
                ", sName='" + sName + '\'' +
                ", cNo=" + cNo +
                ", cName='" + cName + '\'' +
                ", cType='" + cType + '\'' +
                ", cCredit=" + cCredit +
                ", score=" + score +
                ", tNo='" + tNo + '\'' +
                ", tName='" + tName + '\'' +
                ", tPosition='" + tPosition + '\'' +
                '}';
    }

    public void setsNo(String sNo) {
        this.sNo = sNo;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public Integer getcNo() {
        return cNo;
    }

    public void setcNo(Integer cNo) {
        this.cNo = cNo;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType;
    }

    public Integer getcCredit() {
        return cCredit;
    }

    public void setcCredit(Integer cCredit) {
        this.cCredit = cCredit;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String gettNo() {
        return tNo;
    }

    public void settNo(String tNo) {
        this.tNo = tNo;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String gettPosition() {
        return tPosition;
    }

    public void settPosition(String tPosition) {
        this.tPosition = tPosition;
    }

    private String tPosition;

}
