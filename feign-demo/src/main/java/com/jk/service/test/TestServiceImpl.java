package com.jk.service.test;

import com.jk.mapper.test.TestMapper;
import com.jk.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public int getCount() {
        return testMapper.getCount();
    }

    @Override
    public List<FreeUser> queryUser() {
        return testMapper.queryUser();
    }

    @Override
    public List<FreeSkill> querySkill(Integer userid) {
        return testMapper.querySkill(userid);
    }

    @Override
    public List<FreeExperience> queryExperience(Integer userid) {
        return testMapper.queryExperience(userid);
    }

    @Override
    public List<FreeEducation> queryEducation(Integer userid) {
        return testMapper.queryEducation(userid);
    }

    @Override
    public List<FreeProject> queryProject(Integer userid) {
        return testMapper.queryProject(userid);
    }
}
