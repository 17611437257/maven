package com.jk.controller.test;

import com.itextpdf.text.pdf.BaseFont;
import com.jk.model.*;
import com.jk.service.test.TestService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("test")
public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping("toHtml")
    public  String toIndex(){
        return "index";
    }

    @RequestMapping("toJsp")
    public String toJsp(){
        return "showlog";
    }

    @RequestMapping("getCount")
    @ResponseBody
    public int getCount(){
        return  testService.getCount();
    }
    @RequestMapping("sendSms")
    public Boolean sendSms(String phoneNum){
      return true;
    }

    @RequestMapping("queryInfo")
    @ResponseBody
    public HashMap<String,Object> queryInfo() throws Exception {
        HashMap<String,Object> params=new HashMap<String,Object>();
        params.put("title","测试freemarker");
        List<FreeUser> userList=testService.queryUser();
        Integer userid=1;
        List<FreeSkill> skillList=testService.querySkill(userid);
        List<FreeExperience> experienceList=testService.queryExperience(userid);
        List<FreeEducation> educationList=testService.queryEducation(userid);
        List<FreeProject> projectList = testService.queryProject(userid);
        params.put("userlist",userList);
        params.put("skilllist",skillList);
        params.put("experienceList",experienceList);
        params.put("educationList",educationList);
        params.put("projectList",projectList);
        Configuration config = new Configuration();
        String ftlPath="D:\\practice\\";
        config.setDirectoryForTemplateLoading(new File(ftlPath));
        Template template = config.getTemplate("test.ftl");

        // 合并模板文件以及数据将其进行输出
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\practice\\test.html"), "utf-8"));
        template.process(params, out);
        return params;
    }


    @RequestMapping("createWord")
    @ResponseBody
    public HashMap<String,Object> createWord() throws Exception {
        HashMap<String,Object> map=new HashMap<String, Object>();
        map.put("title","测试freemarker");
        List<FreeUser> userList=testService.queryUser();
        map.put("userlist",userList);
        Configuration config = new Configuration();
        String ftlPath="D:\\practice\\";
        config.setDirectoryForTemplateLoading(new File(ftlPath));
        Template template = config.getTemplate("introduce.ftl");
        // 合并模板文件以及数据将其进行输出
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\practice\\introduce.docx"), "utf-8"));
        template.process(map, out);

        return map;
    }

    /**
     * 转pdf页面
     * @return
     */
    @RequestMapping(value = "freeMarkerPdf")
    @ResponseBody
    public Boolean freeMarkerPdf() throws IOException, TemplateException {

         /* 创建数据模型 */
        Integer userid = 1;
        //个人简介
        List<FreeUser> userList=testService.queryUser();
        //教育经历
        List<FreeSkill> skillList=testService.querySkill(userid);
        List<FreeExperience> experienceList=testService.queryExperience(userid);
        List<FreeEducation> educationList=testService.queryEducation(userid);
        List<FreeProject> projectList = testService.queryProject(userid);
        // 制造数据
        Map<Object,Object> map = new HashMap<Object, Object>();
        map.put("title", "简        历");
        map.put("userlist",userList);
        map.put("skilllist",skillList);
        map.put("experienceList",experienceList);
        map.put("educationList",educationList);
        map.put("projectList",projectList);
        /* 创建配置 */
        Configuration cfg = new Configuration();
        /* 指定模板存放的路径 */
        cfg.setDirectoryForTemplateLoading(new File("D:\\practice\\"));
        cfg.setDefaultEncoding("UTF-8");
        /* 从上面指定的模板目录中加载对应的模板文件 */
        Template temp = cfg.getTemplate("test.ftl");

        /* 将生成的内容写入hello .html中 */

        String file1 = "D:\\practice\\myFreemarkerPdf.html";
        File file = new File(file1);
        if (!file.exists())
            file.createNewFile();
        Writer out = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(file), "UTF-8"));
        temp.process(map, out);
        out.flush();

        String url = new File(file1).toURI().toURL().toString();
        String outputFile = "D:\\practice\\contractTemplate.pdf";
        OutputStream os = new FileOutputStream(outputFile);

        ITextRenderer renderer = new ITextRenderer();

        renderer.setDocument(url);

        // 解决中文问题
        ITextFontResolver fontResolver = renderer.getFontResolver();
        try {
           /* simsun.ttc*/
            fontResolver.addFont("D:\\practice\\wordFont\\simsun.ttc", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
           /* fontResolver.addFont("D:\\freemarker\\wordFont\\simsun.ttc", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            fontResolver.addFont("D:\\freemarker\\wordFont\\simsun.ttc", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);*/
        } catch (Exception e) {
            e.printStackTrace();
        }
           /* fontResolver.addFont("C:/Windows/Fonts/ARIALUNI.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);*/

        renderer.layout();
        try {
            renderer.createPDF(os);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("转换成功！");
        os.close();
        return true;
    }





}
