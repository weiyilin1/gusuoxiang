package com.lin.dao;

import com.lin.domain.User;
import com.lin.domain.UserCourse;

import java.util.List;

public interface UserCourseDao {

    //通过userCode查询用户选择的课程
    List<UserCourse> getUserCourseType(String userCode);

    //添加用户课程
    void insertUserCourse(User user, UserCourse userCourse);




}
