package com.lin.dao.impl;

import com.lin.dao.ExperienceDao;
import com.lin.domain.Experience;
import com.lin.domain.Shop;
import com.lin.domain.UserCollectExperience;
import com.lin.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ExperienceDaoImpl implements ExperienceDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Experience> findExperience(String page) {
        String sql = "select * from Experience limit ?,12";
        return template.query(sql,new BeanPropertyRowMapper<>(Experience.class),
                Integer.parseInt(page)*12);

    }

    @Override
    public void collectExperience(UserCollectExperience collectExperience) {
        String sql = "insert into usercollectexperience(username,eCollectTime,eusername," +
                "userCourse,theme,content,up,down,collect,courseTitle)" +
                " values (?,?,?,?,?,?,?)";
        template.update(sql, collectExperience.getUsername(), collectExperience.geteCollectTime(), collectExperience.getEusername(),
                collectExperience.getUserCourse(), collectExperience.getTheme(), collectExperience.getContent(), collectExperience.getUp(),
                collectExperience.getDown(), collectExperience.getCollect(), collectExperience.getCourseTitle());
    }

    @Override
    public void updateCollectNumber(int id) {
        String sql = "UPDATE  Experience SET collect=collect+1 WHERE id=?";
        template.update(sql, id);
    }
}
