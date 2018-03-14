package com.jk.model;

import java.io.Serializable;

public class FreeProject implements Serializable {

    private Integer id;

    private String huanjing;

    private String kuangjia;

    private String miaoshu;

    private String zmiaoshu;

    private String title;

    private Integer userid;
    private String mukuai;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHuanjing() {
        return huanjing;
    }

    public void setHuanjing(String huanjing) {
        this.huanjing = huanjing;
    }

    public String getKuangjia() {
        return kuangjia;
    }

    public void setKuangjia(String kuangjia) {
        this.kuangjia = kuangjia;
    }

    public String getMiaoshu() {
        return miaoshu;
    }

    public void setMiaoshu(String miaoshu) {
        this.miaoshu = miaoshu;
    }

    public String getZmiaoshu() {
        return zmiaoshu;
    }

    public void setZmiaoshu(String zmiaoshu) {
        this.zmiaoshu = zmiaoshu;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getMukuai() {
        return mukuai;
    }

    public void setMukuai(String mukuai) {
        this.mukuai = mukuai;
    }

    @Override
    public String toString() {
        return "FreeProject{" +
                "id=" + id +
                ", huanjing='" + huanjing + '\'' +
                ", kuangjia='" + kuangjia + '\'' +
                ", miaoshu='" + miaoshu + '\'' +
                ", zmiaoshu='" + zmiaoshu + '\'' +
                ", title='" + title + '\'' +
                ", userid=" + userid +
                ", mukuai='" + mukuai + '\'' +
                '}';
    }
}
