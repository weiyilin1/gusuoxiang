package com.lin.domain;
@SuppressWarnings("all")
public class Experience {
    private int id;
    //用户选择的课程
    private String userCourse;
    //发表经验的用户名
    private String username;
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
        return "Experience{" +
                "id=" + id +
                ", userCourse='" + userCourse + '\'' +
                ", username='" + username + '\'' +
                ", theme='" + theme + '\'' +
                ", content='" + content + '\'' +
                ", up=" + up +
                ", down=" + down +
                ", collect=" + collect +
                ", courseTitle='" + courseTitle + '\'' +
                '}';
    }
}
