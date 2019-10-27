package com.lin.service.impl;

import com.lin.bean.AccountBean;
import com.lin.domain.Course;
import com.lin.dao.CourseDao;
import com.lin.service.CourseService;

import java.util.List;

/**
 * (Course)表服务实现类
 *
 */
public class CourseServiceImpl implements CourseService {
    private CourseDao courseDao = (CourseDao) AccountBean.getBean("CourseDao");

    @Override
    public List<Course> findCourse(String page) {
        return this.courseDao.queryAllByLimit(Integer.parseInt(page), 12);
    }

}