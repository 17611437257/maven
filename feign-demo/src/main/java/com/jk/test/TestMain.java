package com.jk.test;

import com.jk.model.UserBean;
import com.jk.service.test.TestService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class TestMain {


    public static void main(String[] args) throws Exception {
        HashMap<String,Object> params=new HashMap<String, Object>();
        params.put("title","测试freemarker");
        ArrayList<UserBean> userBeans = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            UserBean userBean = new UserBean();
            userBean.setAge(20);
            userBean.setName("杨宇");
            userBean.setSex("男");
            userBeans.add(userBean);
        }
        params.put("userBeans",userBeans);
        Configuration config = new Configuration();
        String ftlPath="D:\\practice\\";
        config.setDirectoryForTemplateLoading(new File(ftlPath));
        Template template = config.getTemplate("test.ftl");

        // 合并模板文件以及数据将其进行输出
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\practice\\test.html"), "utf-8"));

        template.process(params, out);
    }
    
    
}
