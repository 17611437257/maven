package com.jk.model;

import java.io.Serializable;

public class FreeSkill implements Serializable {

    private Integer id;

    private String skillinfo;

    private Integer userid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSkillinfo() {
        return skillinfo;
    }

    public void setSkillinfo(String skillinfo) {
        this.skillinfo = skillinfo;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "FreeSkill{" +
                "id=" + id +
                ", skillinfo='" + skillinfo + '\'' +
                ", userid=" + userid +
                '}';
    }
}
