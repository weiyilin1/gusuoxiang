package com.lin.dao;

import com.lin.domain.Experience;
import com.lin.domain.UserCollectExperience;

import java.util.List;

public interface ExperienceDao {
    List<Experience> findExperience(String page);

    void collectExperience(UserCollectExperience collectExperience);

    void updateCollectNumber(int id);
}
