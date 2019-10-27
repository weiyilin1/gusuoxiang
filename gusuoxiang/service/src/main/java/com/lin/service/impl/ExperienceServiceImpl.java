package com.lin.service.impl;

import com.lin.dao.ExperienceDao;
import com.lin.dao.impl.ExperienceDaoImpl;
import com.lin.domain.Experience;
import com.lin.service.ExperienceService;

import java.util.List;

public class ExperienceServiceImpl implements ExperienceService {
    private ExperienceDao dao = new ExperienceDaoImpl();


    @Override
    public List<Experience> findExperience(String page) {
        return dao.findExperience(page);
    }
}
