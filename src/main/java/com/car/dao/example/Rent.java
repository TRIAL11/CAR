package com.car.dao.example;

import java.util.Date;

public class Rent {
    private Integer rno;

    private Integer cno;

    private Integer ucode;

    private Date rlend;

    private Date rreturn;

    private Float rprice;

    private Integer rstate;

    public Integer getRno() {
        return rno;
    }

    public void setRno(Integer rno) {
        this.rno = rno;
    }

    public Integer getCno() {
        return cno;
    }

    public void setCno(Integer cno) {
        this.cno = cno;
    }

    public Integer getUcode() {
        return ucode;
    }

    public void setUcode(Integer ucode) {
        this.ucode = ucode;
    }

    public Date getRlend() {
        return rlend;
    }

    public void setRlend(Date rlend) {
        this.rlend = rlend;
    }

    public Date getRreturn() {
        return rreturn;
    }

    public void setRreturn(Date rreturn) {
        this.rreturn = rreturn;
    }

    public Float getRprice() {
        return rprice;
    }

    public void setRprice(Float rprice) {
        this.rprice = rprice;
    }

    public Integer getRstate() {
        return rstate;
    }

    public void setRstate(Integer rstate) {
        this.rstate = rstate;
    }
}