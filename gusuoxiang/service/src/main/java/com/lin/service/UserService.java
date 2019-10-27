package com.lin.service;


import com.lin.domain.*;

import javax.servlet.http.Cookie;
import java.util.List;
import java.util.Map;
@SuppressWarnings("all")
public interface UserService {
    /**
     * 注册用户
     *
     * @param user
     * @return
     */
    boolean register(Map<String, String[]> user, String code);
   
    /**
     * 登录验证
     * @param user
     * @return
     */
    User login(Map<String,String[]> user);

    /**
     * 查询用户选择的课程
     * @param user
     * @return
     */

    List<String> getUserCourseType(User user);

    /**
     * 发送验证码
     * @param email
     * @return
     */
    String sendCode(String email);

    /**
     * 检验邮箱
     * @param email
     * @return
     */
    boolean checkEmail(String email);

    /**
     * 检验用户名
     * @param username
     * @return
     */

    boolean checkUsername(String username);

    /**
     * 查询用户自己写的课程笔记
     * @param user
     * @return
     */
    List<CourseNote> findUserNote(User user);

    /**
     * 查询用户自己写的经验
     * @param user
     * @return
     */

    List<Experience> findUserExperience(User user);

    /**
     * 查询用户收藏的课程
     * @param user
     * @return
     */


    List<UserCollectCourse> findCollectCourse(User user);

    /**
     * 查询用户收藏的经验
     * @param user
     * @return
     */
    List<UserCollectExperience> findCollectExperience(User user);

    /**
     * 选择课程
     * @param user
     * @param map
     * @return
     */
    List<Cookie> chooseCourse(User user, Map<String, String[]> map);

    /**
     * 收藏课程
     * @param user
     * @param map
     * @return
     */

    boolean  collectCourse(User user,Map<String, String[]> map);

    /**
     * 收藏经验
     * @param user
     * @param map
     * @return
     */

    boolean collectExperience(User user,Map<String, String[]> map);

    /**
     * 脑部数据
     * @param search
     * @param type
     * @return
     */

    List<String> searchData(String search, String type);

    /**
     * 搜索课程
     * @param search
     * @return
     */

    List<Course> searchCourse(String search);

    /**
     * 搜索经验
     * @param search
     * @return
     */

    List<Experience> searchExperience(String search);

    /**
     * 收缩商城
     * @param search
     * @return
     */

    List<Shop> searchShop(String search);
}
