package com.car.dao.example;

public class Cartype {
    private Integer tno;

    private String tname;

    private Integer ttoal;

    public Integer getTno() {
        return tno;
    }

    public void setTno(Integer tno) {
        this.tno = tno;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname == null ? null : tname.trim();
    }

    public Integer getTtoal() {
        return ttoal;
    }

    public void setTtoal(Integer ttoal) {
        this.ttoal = ttoal;
    }
}