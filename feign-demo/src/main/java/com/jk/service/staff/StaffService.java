package com.jk.service.staff;

import com.jk.model.LogBean;
import com.jk.model.StaffBean;

import java.util.List;

public interface StaffService {
    List<StaffBean> queryStaff();

    List<StaffBean> queryStaffByPage(Integer page, Integer limit);

    void addStaff(StaffBean staffBean);

    void delStaff(Integer id);

    void updateStaff(StaffBean staffBean);

    StaffBean queryStaffByid(Integer id);

    List<LogBean> queryNewLogs();

    List<LogBean> queryNewLogsBypage(Integer page, Integer limit);
}
