package com.car.dao.example;

public class Staff {
    private Integer sno;

    private Integer dno;

    private String sname;

    private String sphone;

    private String saccount;

    private String spaw;

    public Integer getSno() {
        return sno;
    }

    public void setSno(Integer sno) {
        this.sno = sno;
    }

    public Integer getDno() {
        return dno;
    }

    public void setDno(Integer dno) {
        this.dno = dno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public String getSphone() {
        return sphone;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone == null ? null : sphone.trim();
    }

    public String getSaccount() {
        return saccount;
    }

    public void setSaccount(String saccount) {
        this.saccount = saccount == null ? null : saccount.trim();
    }

    public String getSpaw() {
        return spaw;
    }

    public void setSpaw(String spaw) {
        this.spaw = spaw == null ? null : spaw.trim();
    }
}