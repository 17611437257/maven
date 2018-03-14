package com.jk.mapper.test;

import com.jk.model.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface TestMapper {
    @Select("select count(1) from t_test")
    int getCount();
    @Select("select * from free_user")
    List<FreeUser> queryUser();
    @Select("select fs.* from free_user fu,free_skill fs where fu.id=fs.userid and fs.userid=#{userid}")
    List<FreeSkill> querySkill(@Param("userid") Integer userid);
    @Select("select fe.* from free_user fu,free_experience fe where fu.id=fe.userid and fe.userid=#{userid}")
    List<FreeExperience> queryExperience(Integer userid);
    @Select("select fe.* from free_user fu,free_education fe where fu.id=fe.userid and fe.userid=#{userid}")
    List<FreeEducation> queryEducation(Integer userid);
    @Select("select fp.* from free_user fu,free_project fp where fu.id=fp.userid and fp.userid=#{userid}")
    List<FreeProject> queryProject(Integer userid);
}
