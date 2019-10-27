package com.lin.domain;

import java.util.Date;

@SuppressWarnings("all")
public class UserCollectExperience {

    private int id;
    //用户名
    private String username;
    //收藏经验的时间
    private Date eCollectTime;
    //用户选择的课程
    private String userCourse;
    //发表经验的用户名
    private String eusername;
    //经验的主题
    private String theme;
    //经验的内容
    private String content;
    //经验的点赞数
    private int up;
    //经验的踩数
    private int down;
    //经验的收藏数
    private int collect;
    //课程的大类型
    private String courseTitle;

    public String getEusername() {
        return eusername;
    }

    public void setEusername(String eusername) {
        this.eusername = eusername;
    }

    public Date geteCollectTime() {
        return eCollectTime;
    }

    public void seteCollectTime(Date eCollectTime) {
        this.eCollectTime = eCollectTime;
    }

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

    public String getUserCourse() {
        return userCourse;
    }

    public void setUserCourse(String userCourse) {
        this.userCourse = userCourse;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public int getCollect() {
        return collect;
    }

    public void setCollect(int collect) {
        this.collect = collect;
    }

    @Override
    public String toString() {
        return "UserCollectExperience{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", eCollectTime=" + eCollectTime +
                ", userCourse='" + userCourse + '\'' +
                ", eusername='" + eusername + '\'' +
                ", theme='" + theme + '\'' +
                ", content='" + content + '\'' +
                ", up=" + up +
                ", down=" + down +
                ", collect=" + collect +
                ", courseTitle='" + courseTitle + '\'' +
                '}';
    }
}
