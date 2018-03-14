package com.jk.controller.staff;

import com.jk.model.StaffBean;
import com.jk.service.staff.StaffService;
import com.jk.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("staff")
public class StaffController {
    @Autowired
    private StaffService staffService;

    /**
     * 跳转到展示职员信息页面
     * @return
     */
    @RequestMapping("toshowStaff")
    public String toshowStaff(){
        return "staff/showstaff";
    }

    /**
     * 查询职员数据
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("queryStaff")
    @ResponseBody
    public Map<String,Object> queryStaff(Integer page, Integer limit){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",staffService.queryStaff().size());
        map.put("data",staffService.queryStaffByPage(page,limit));
        return map;
    }

    /**
     * 上传
     * @param file
     * @return
     */
    @RequestMapping(value = "uploadPhoto", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> uploadPhoto(MultipartFile file){
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            String photoName = FileUtil.upFile(file, ConstantsBean.IMG_PATH);
            String path = ConstantsBean.IMG_SERVER_PATH+photoName;
            map.put("success", true);
            map.put("path", path);

        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
        }
        return map;

    }

    /**
     * 添加
     * @param staffBean
     * @return
     */
    @RequestMapping("addStaff")
    @ResponseBody
    public Map<String,Object> addStaff(StaffBean staffBean){
        Map<String,Object> map=new HashMap<String,Object>();
        try {
            staffService.addStaff(staffBean);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("delStaff")
    @ResponseBody
    public Map<String,Object> delStaff(Integer id){
        Map<String,Object> map=new HashMap<String,Object>();
        try {
            staffService.delStaff(id);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }

    @RequestMapping("queryStaffByid")
    @ResponseBody
    public StaffBean queryStaffByid(Integer id){
        return staffService.queryStaffByid(id);
    }

    @RequestMapping("updateStaff")
    @ResponseBody
    public Map<String,Object> updateStaff(StaffBean staffBean){
        Map<String,Object> map=new HashMap<String,Object>();
        try {
            staffService.updateStaff(staffBean);
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
        }
        return map;
    }



}
