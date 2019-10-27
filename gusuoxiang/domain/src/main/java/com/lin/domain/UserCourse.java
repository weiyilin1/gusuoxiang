package com.lin.domain;

import java.io.Serializable;

/**
 * (UserCourse)实体类
 *
 */
public class UserCourse implements Serializable {
    //主键id
    private int id;
    //用户名称
    private String username;
    //用户选择的课程的类型
    private String courseType;
    //课程的大类型
    private String courseTitle;

    @Override
    public String toString() {
        return "UserCourse{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", courseType='" + courseType + '\'' +
                ", courseTitle='" + courseTitle + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }
}