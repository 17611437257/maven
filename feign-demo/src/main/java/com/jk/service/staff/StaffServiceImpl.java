package com.jk.service.staff;

import com.jk.mapper.staff.StaffMapper;
import com.jk.model.LogBean;
import com.jk.model.StaffBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffMapper staffMapper;
    @Override
    public List<StaffBean> queryStaff() {
        return staffMapper.queryStaff();
    }

    @Override
    public List<StaffBean> queryStaffByPage(Integer page, Integer limit) {
        page=(page-1)*limit;
        return staffMapper.queryStaffByPage(page,limit);
    }

    @Override
    public void addStaff(StaffBean staffBean) {
        staffMapper.addStaff(staffBean);
    }

    @Override
    public void delStaff(Integer id) {
        staffMapper.delStaff(id);
    }

    @Override
    public void updateStaff(StaffBean staffBean) {
        staffMapper.updateStaff(staffBean);
    }

    @Override
    public StaffBean queryStaffByid(Integer id) {
        return staffMapper.queryStaffByid(id);
    }

    @Override
    public List<LogBean> queryNewLogs() {
        return staffMapper.queryNewLogs();
    }

    @Override
    public List<LogBean> queryNewLogsBypage(Integer page, Integer limit) {
        page=(page-1)*limit;
        return staffMapper.queryNewLogsBypage(page,limit);
    }
}
