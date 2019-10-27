package com.lin.domain;

public class CourseNote {
    private int id;
    //课程笔记的用户
    private String username;
    //用户笔记
    private String note;
    //笔记点赞数
    private int up;
    //笔记踩数
    private int down;
    //课程名字
    private String courseName;
    //课程类型
    private String courseType;
    //课程的大类型
    private String courseTitle;

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getUp() {
        return up;
    }

    public void setUp(int up) {
        this.up = up;
    }

    public int getDown() {
        return down;
    }

    public void setDown(int down) {
        this.down = down;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    @Override
    public String toString() {
        return "CourseNote{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", note='" + note + '\'' +
                ", up=" + up +
                ", down=" + down +
                ", courseName='" + courseName + '\'' +
                ", courseType='" + courseType + '\'' +
                ", courseTitle='" + courseTitle + '\'' +
                '}';
    }
}
