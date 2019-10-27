package com.lin.domain;

import java.io.Serializable;

/**
 * (Course)实体类
 *
 * @author makejava
 * @since 2019-10-20 08:24:02
 */
@SuppressWarnings("all")
public class Course implements Serializable {
    //主键id
    private Integer id;
    //课程名字（如7天掌握吉他）
    private String courseName;
    //课程图片
    private String coursePhoto;
    //课程链接
    private String courseUrl;
    //课程类型（如吉他）
    private String courseType;
    //课程作者
    private String courseAuthor;
    //课程点赞数
    private int courseUp;
    //课程踩数
    private int courseDown;
    //课程收藏数
    private int courseCollect;
    //课程的大类型
    private String courseTitle;

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCoursePhoto() {
        return coursePhoto;
    }

    public void setCoursePhoto(String coursePhoto) {
        this.coursePhoto = coursePhoto;
    }

    public String getCourseUrl() {
        return courseUrl;
    }

    public void setCourseUrl(String courseUrl) {
        this.courseUrl = courseUrl;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getCourseAuthor() {
        return courseAuthor;
    }

    public void setCourseAuthor(String courseAuthor) {
        this.courseAuthor = courseAuthor;
    }

    public int getCourseUp() {
        return courseUp;
    }

    public void setCourseUp(int courseUp) {
        this.courseUp = courseUp;
    }

    public int getCourseDown() {
        return courseDown;
    }

    public void setCourseDown(int courseDown) {
        this.courseDown = courseDown;
    }

    public int getCourseCollect() {
        return courseCollect;
    }

    public void setCourseCollect(int courseCollect) {
        this.courseCollect = courseCollect;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", coursePhoto='" + coursePhoto + '\'' +
                ", courseUrl='" + courseUrl + '\'' +
                ", courseType='" + courseType + '\'' +
                ", courseAuthor='" + courseAuthor + '\'' +
                ", courseUp=" + courseUp +
                ", courseDown=" + courseDown +
                ", courseCollect=" + courseCollect +
                ", courseTitle='" + courseTitle + '\'' +
                '}';
    }
}