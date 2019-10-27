package com.lin.service;

import com.lin.domain.Experience;
import java.util.List;

public interface ExperienceService {
    /**
     * 通过页数查询经验
     * @param page
     * @return
     */
    List<Experience> findExperience(String page);
}
