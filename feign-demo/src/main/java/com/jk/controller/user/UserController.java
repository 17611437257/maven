package com.jk.controller.user;


import com.alibaba.fastjson.JSON;
import com.jk.controller.common.ReturnData;
import com.jk.model.LogBean;
import com.jk.pool.ThreadPool;
import com.jk.service.staff.StaffService;
import com.jk.service.user.UserService;
import com.jk.service.user.UserThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private StaffService staffService;

    @RequestMapping("toshowmain")
    public String toshowmain(){
        return "showmain";
    }

    @RequestMapping("toshowLog")
    public String toshowLog(){
        return "showlog";
    }

    @RequestMapping("loginUser")
    @ResponseBody
    public Boolean loginUser(String username,String password){
        LogBean logBean = new LogBean();
        logBean.setUsername("123");
        logBean.setIp("127.0.0.1");
        logBean.setIpaddress("局域网");
        ThreadPool.executor(new UserThread(userService,logBean));
        return true;
    }

    @RequestMapping("queryStaff")
    @ResponseBody
    public Map queryStaff(Integer page,Integer limit){
        return  userService.queryStaff(page,limit);
    }

    @RequestMapping("queryLog")
    @ResponseBody
    public Map queryLog(Integer page,Integer limit){
        return  userService.queryLog(page,limit);
    }

    @RequestMapping("queryNewLogs")
    @ResponseBody
    public ReturnData queryNewLogs(Integer page,Integer limit){
        ReturnData returnData = new ReturnData();
        returnData.setCode(0);
        returnData.setMsg("");
        returnData.setCount(staffService.queryNewLogs().size());
        returnData.setData(staffService.queryNewLogsBypage(page,limit));
        return returnData;
    }
}
