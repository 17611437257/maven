package com.jk.service.test;

import com.jk.model.*;

import java.util.List;

public interface TestService {
    int getCount();

    List<FreeUser> queryUser();

    List<FreeSkill> querySkill(Integer userid);

    List<FreeExperience> queryExperience(Integer userid);

    List<FreeEducation> queryEducation(Integer userid);

    List<FreeProject> queryProject(Integer userid);
}
