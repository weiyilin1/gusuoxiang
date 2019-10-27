package com.lin.dao;

import com.lin.domain.*;

import java.util.List;

/**
 * (User)表数据库访问层
 *
 */

public interface UserDao {

    /**
     * 通过邮箱查询用户信息
     *
     * @param email 昵称
     * @return 实例对象
     */
    User findByEmail(String email);


    /**
     * 修改数据
     */
    void update(User user);


    /**
     * 通过邮箱和密码查询用户
     *
     */

    User findByUsernameOrEmailAndPassword(User user);

    User findByUsername(String username);

    void saveUser(User user);

    List<CourseNote> findUserNote(User user);

    List<Experience> findUserExperience(User user);


    void addUserCourse(UserCourse course);

    List<UserCollectCourse> findCollectCourse(User user);

    List<UserCollectExperience> findCollectExperience(User user);

    List<UserCourse> getUserCourseType(User user);

    List<String> searchCourseData(String search);

    List<String> searchExperienceData(String search);

    List<String> searchShopData(String search);

    List<Course> searchCourse(String search);

    List<Experience> searchExperience(String search);

    List<Shop> searchShop(String search);
}