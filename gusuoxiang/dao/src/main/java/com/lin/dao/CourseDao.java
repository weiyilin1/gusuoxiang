package com.lin.dao;

import com.lin.domain.Course;
import com.lin.domain.UserCollectCourse;

import java.util.List;

/**
 * (Course)表数据库访问层
 *
 */
public interface CourseDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Course queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Course> queryAllByLimit(int offset, int limit);


    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    List<Course> queryAll();

    /**
     * 获得课程总条数
     * @return
     */
    int queryTotal(String courseType);

    /**
     * 更新课程的收藏人数
     *
     * @param
     */
    void updateCollectNumber(int id);




    void collectCourse(UserCollectCourse collectCourse);
}