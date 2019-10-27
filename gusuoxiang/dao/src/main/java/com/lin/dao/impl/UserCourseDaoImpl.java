package com.lin.dao.impl;

import com.lin.dao.UserCourseDao;
import com.lin.domain.User;
import com.lin.domain.UserCourse;
import com.lin.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserCourseDaoImpl implements UserCourseDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<UserCourse> getUserCourseType(String userCode) {
        String sql = "SELECT * FROM userCourse WHERE userCode=?";
        List<UserCourse> userCourses = template.query(sql, new BeanPropertyRowMapper<UserCourse>(UserCourse.class),userCode);
        return userCourses;
    }

    @Override
    public void insertUserCourse(User user, UserCourse userCourse) {
        //1.定义sql
        String sql = "insert into userCourse (userCode,courseType,target,targetDate) values(?,?,?,?)";
        //2.执行sql
        template.update(sql,  userCourse.getCourseType());
    }

    public static void main(String[] args) {
    }


}
