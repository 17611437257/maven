package com.jk.service.user;

import com.alibaba.fastjson.JSON;
import com.jk.model.LogBean;
import org.springframework.beans.factory.annotation.Autowired;

public class UserThread implements Runnable {

    private UserService userService;

    private LogBean logBean;

    @Override
    public void run() {
        userService.saveLog(JSON.toJSONString(logBean));
        System.out.println(logBean.toString());
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public LogBean getLogBean() {
        return logBean;
    }

    public void setLogBean(LogBean logBean) {
        this.logBean = logBean;
    }

    public UserThread(UserService userService, LogBean logBean) {
        this.userService = userService;
        this.logBean = logBean;
    }

    public UserThread() {
    }
}
