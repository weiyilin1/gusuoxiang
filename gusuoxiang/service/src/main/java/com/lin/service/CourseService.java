package com.lin.service;

import com.lin.domain.Course;
import java.util.List;

/**
 * 课程的service类
 */
public interface  CourseService {

    /**
     * 通过页数查询课程
     * @param page
     * @return
     */
    List<Course> findCourse(String page);

}