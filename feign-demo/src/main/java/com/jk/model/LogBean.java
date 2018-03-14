package com.jk.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogBean implements Serializable {

    private String id;

    private String ip;

    private String ipaddress;

    private String status;

    private String username;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date logintime;

    private Integer flag;

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLogintime() {
        if(logintime==null){
            return null;
        }
        SimpleDateFormat sim=new SimpleDateFormat();
        return sim.format(logintime);
    }

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }

    @Override
    public String toString() {
        return "LogBean{" +
                "id='" + id + '\'' +
                ", ip='" + ip + '\'' +
                ", ipaddress='" + ipaddress + '\'' +
                ", status='" + status + '\'' +
                ", username='" + username + '\'' +
                ", logintime=" + logintime +
                ", flag=" + flag +
                '}';
    }
}
