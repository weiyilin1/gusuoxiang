package com.lin.domain;

import java.io.Serializable;
import java.util.List;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2019-10-16 10:43:34
 */
@SuppressWarnings("all")
public class User implements Serializable {
    //id
    private Integer id;
    //用户名
    private String username;
    //密码
    private String password;
    //用户的邮箱
    private String email;
    //用户选择的课程
    private List<String> courseTypes;
    //用户头像地址
    private String userPhoto;

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getCourseTypes() {
        return courseTypes;
    }

    public void setCourseTypes(List<String> courseTypes) {
        this.courseTypes = courseTypes;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", courseTypes=" + courseTypes +
                ", userPhoto='" + userPhoto + '\'' +
                '}';
    }
}