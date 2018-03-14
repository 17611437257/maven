package com.jk.model;

import java.io.Serializable;

public class FreeExperience implements Serializable{

    private Integer id;

    private String worktime;

    private String companyname;

    private String workskill;

    private Integer userid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorktime() {
        return worktime;
    }

    public void setWorktime(String worktime) {
        this.worktime = worktime;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getWorkskill() {
        return workskill;
    }

    public void setWorkskill(String workskill) {
        this.workskill = workskill;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "FreeExperience{" +
                "id=" + id +
                ", worktime='" + worktime + '\'' +
                ", companyname='" + companyname + '\'' +
                ", workskill='" + workskill + '\'' +
                ", userid=" + userid +
                '}';
    }
}
