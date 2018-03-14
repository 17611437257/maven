package com.jk.model;

import java.io.Serializable;

public class FreeEducation implements Serializable {

    private Integer id;

    private String educationtime;

    private String companyname;

    private String educationposition;

    private Integer userid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEducationtime() {
        return educationtime;
    }

    public void setEducationtime(String educationtime) {
        this.educationtime = educationtime;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getEducationposition() {
        return educationposition;
    }

    public void setEducationposition(String educationposition) {
        this.educationposition = educationposition;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "FreeEducation{" +
                "id=" + id +
                ", educationtime='" + educationtime + '\'' +
                ", companyname='" + companyname + '\'' +
                ", educationposition='" + educationposition + '\'' +
                ", userid=" + userid +
                '}';
    }
}
