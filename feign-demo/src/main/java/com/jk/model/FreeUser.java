package com.jk.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FreeUser implements Serializable{

    private Integer id;

    private String username;
    private String usersex;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    private String jiguan;
    private String worktime;
    private Integer userage;
    private String usereducation;
    private String userprofessional;
    private String userphone;
    private String useremail;
    private String userintroduce;
    private String workdefined;
    private String workposition;
    private String worksalary;
    private String workaddress;

    @Override
    public String toString() {
        return "FreeUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", usersex='" + usersex + '\'' +
                ", createtime=" + createtime +
                ", jiguan='" + jiguan + '\'' +
                ", worktime='" + worktime + '\'' +
                ", userage=" + userage +
                ", usereducation='" + usereducation + '\'' +
                ", userprofessional='" + userprofessional + '\'' +
                ", userphone='" + userphone + '\'' +
                ", useremail='" + useremail + '\'' +
                ", userintroduce='" + userintroduce + '\'' +
                ", workdefined='" + workdefined + '\'' +
                ", workposition='" + workposition + '\'' +
                ", worksalary='" + worksalary + '\'' +
                ", workaddress='" + workaddress + '\'' +
                '}';
    }

    public Integer getUserage() {
        return userage;
    }

    public void setUserage(Integer userage) {
        this.userage = userage;
    }

    public String getWorkdefined() {
        return workdefined;
    }

    public void setWorkdefined(String workdefined) {
        this.workdefined = workdefined;
    }

    public String getWorkposition() {
        return workposition;
    }

    public void setWorkposition(String workposition) {
        this.workposition = workposition;
    }

    public String getWorksalary() {
        return worksalary;
    }

    public void setWorksalary(String worksalary) {
        this.worksalary = worksalary;
    }

    public String getWorkaddress() {
        return workaddress;
    }

    public void setWorkaddress(String workaddress) {
        this.workaddress = workaddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsersex() {
        return usersex;
    }

    public void setUsersex(String usersex) {
        this.usersex = usersex;
    }

    public String getCreatetime() {
        if(createtime==null){
            return null;
        }
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sim.format(createtime);
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getJiguan() {
        return jiguan;
    }

    public void setJiguan(String jiguan) {
        this.jiguan = jiguan;
    }

    public String getWorktime() {
        return worktime;
    }

    public void setWorktime(String worktime) {
        this.worktime = worktime;
    }

    public String getUsereducation() {
        return usereducation;
    }

    public void setUsereducation(String usereducation) {
        this.usereducation = usereducation;
    }

    public String getUserprofessional() {
        return userprofessional;
    }

    public void setUserprofessional(String userprofessional) {
        this.userprofessional = userprofessional;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUserintroduce() {
        return userintroduce;
    }

    public void setUserintroduce(String userintroduce) {
        this.userintroduce = userintroduce;
    }

}
