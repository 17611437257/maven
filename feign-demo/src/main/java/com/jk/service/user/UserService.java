package com.jk.service.user;


import com.jk.controller.common.ReturnData;
import com.jk.model.LogBean;
import com.jk.model.StaffBean;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(value="provider-log")
public interface UserService {

    @RequestMapping("/log/addLog")
    void saveLog(@RequestParam("logbeanStr") String logbeanStr);

    @RequestMapping("/staff/queryStaff")
    Map queryStaff(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit);
    @RequestMapping("/log/queryLogs")
    Map queryLog(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit);

    /*@RequestMapping("/staff/queryStaff")
    Map queryStaff(@RequestParam("page")Integer page, @RequestParam("limit")Integer limit);*/
}
