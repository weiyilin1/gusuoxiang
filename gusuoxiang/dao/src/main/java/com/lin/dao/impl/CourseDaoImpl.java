package com.lin.dao.impl;

import com.lin.dao.CourseDao;
import com.lin.domain.Course;
import com.lin.domain.UserCollectCourse;
import com.lin.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
@SuppressWarnings("all")
public class CourseDaoImpl implements CourseDao{
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */

    @Override
    public Course queryById(Integer id) {
        String sql = "SELECT * FROM course WHERE id=?";
        Course course = template.queryForObject(sql, new BeanPropertyRowMapper<Course>(Course.class), id);
        return course;
    }
    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Course> queryAllByLimit(int offset, int limit) {
        String sql = "select * from course limit ?,?";
        List<Course> courses = template.query(sql, new BeanPropertyRowMapper<Course>(Course.class), offset, limit);
        return courses;
    }

    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @Override
    public List<Course> queryAll() {
        String sql = "select * from course";
        List<Course> courses = template.query(sql, new BeanPropertyRowMapper<Course>(Course.class));
        return courses;
    }

    /**
     * 通过课程类型查询课程总条数
     * @param courseType
     * @return
     */
    @Override
    public int queryTotal(String courseType) {
        String sql = "select count(*) from course where courseType = ? ";
        int total = template.queryForObject(sql, Integer.class,courseType);
        return total;
    }

    @Override
    public void updateCollectNumber(int id) {
        String sql = "UPDATE  course SET courseCollect=courseCollect+1 WHERE id=?";
        template.update(sql, id);
    }

    /**
     * 收藏课程
     * @param collectCourse
     */
    @Override
    public void collectCourse(UserCollectCourse collectCourse) {
        String sql = "insert into userCollectCourse(username,courseCollectTime,courseName," +
                "courseAuthor,coursePhoto,courseUrl,courseUp,courseDown,courseCollect,courseType)" +
                " values (?,?,?,?,?,?,?)";
        template.update(sql, collectCourse.getUsername(), collectCourse.getCourseCollectTime(), collectCourse.getCourseName(),
                collectCourse.getCourseAuthor(), collectCourse.getCoursePhoto(), collectCourse.getCourseUrl(), collectCourse.getCourseUp(),
                collectCourse.getCourseDown(), collectCourse.getCourseCollect(), collectCourse.getCourseType());
    }




    public static void main(String[] args) {
        CourseDao dao = new CourseDaoImpl();
        int total = dao.queryTotal("四级");
        System.out.println(total);

    }


}
