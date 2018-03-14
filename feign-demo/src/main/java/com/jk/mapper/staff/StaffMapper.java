package com.jk.mapper.staff;

import com.jk.model.LogBean;
import com.jk.model.StaffBean;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface StaffMapper {
    @Select("select * from layui_staff")
    List<StaffBean> queryStaff();
    @Select("select * from layui_staff limit #{page},#{limit}")
    List<StaffBean> queryStaffByPage(@Param("page") Integer page, @Param("limit") Integer limit);
    @Insert("insert into layui_staff (staffname,staffage,staffsex,staffinfo,staffhobby,staffeducation,staffimg,createtime) values (#{staffname},#{staffage},#{staffsex},#{staffinfo},#{staffhobby},#{staffeducation},#{staffimg},#{createtime}) ")
    void addStaff(StaffBean staffBean);
    @Delete("DELETE  FROM LAYUI_STAFF WHERE ID=#{id}")
    void delStaff(@Param("id") Integer id);
    @Select("select * from layui_staff where id=#{id}")
    StaffBean queryStaffByid(@Param("id") Integer id);
    @Update("UPDATE LAYUI_STAFF SET staffname=#{staffname},staffage=#{staffage},staffsex=#{staffsex},staffinfo=#{staffinfo},staffhobby=#{staffhobby},staffeducation=#{staffeducation},staffimg=#{staffimg},createtime=#{createtime} WHERE ID=#{id}")
    void updateStaff(StaffBean staffBean);

    List<LogBean> queryNewLogs();

    List<LogBean> queryNewLogsBypage(Integer page, Integer limit);
}
