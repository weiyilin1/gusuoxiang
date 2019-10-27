package com.lin.dao.impl;

import com.lin.dao.UserDao;
import com.lin.domain.*;
import com.lin.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SuppressWarnings("all")
public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 通过邮箱查询用户信息
     *
     * @param email 邮箱
     * @return 实例对象
     */
    @Override
    public User findByEmail(String email) {
        User user = null;
        try {
            //1.定义sql
            String sql = "select * from user where email = ? ";
            //2.执行sql
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), email);
        } catch (Exception e) {
        }
        return user;
    }

    @Override
    public User findByUsername(String username) {
        User user = null;
        try {
            //1.定义sql
            String sql = "select * from user where username = ? ";
            //2.执行sql
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
        } catch (Exception e) {
        }
        return user;
    }

    @Override
    public void saveUser(User user) {
        String sql = "insert into user(username,email,password) values (?,?,?)";
        template.update(sql, user.getUsername(), user.getEmail(), user.getPassword());
    }

    @Override
    public List<CourseNote> findUserNote(User user) {
        String sql = "select * from courseNote where username=?";
        List<CourseNote> list = template.query(sql, new BeanPropertyRowMapper<>(CourseNote.class), user.getUsername());
        return list;
    }

    @Override
    public List<Experience> findUserExperience(User user) {
        String sql = "select * from experience where username=?";
        List<Experience> list = template.query(sql, new BeanPropertyRowMapper<>(Experience.class), user.getUsername());
        return list;
    }

    @Override
    public void addUserCourse(UserCourse course) {
        String sql = "insert into userCouurse(username,courseTittle,CourseType) values (?,?,?)";
        template.update(sql, course.getUsername(), course.getCourseTitle(), course.getCourseTitle());
    }

    @Override
    public List<UserCollectCourse> findCollectCourse(User user) {
        String sql = "select * from userCollectCourse where useranme=?";
        return template.query(sql, new BeanPropertyRowMapper<>(UserCollectCourse.class), user.getUsername());
    }

    @Override
    public List<UserCollectExperience> findCollectExperience(User user) {
        String sql = "select * from UserCollectExperience where username =?";
        return template.query(sql, new BeanPropertyRowMapper<>(UserCollectExperience.class), user.getUsername());
    }

    @Override
    public List<UserCourse> getUserCourseType(User user) {
        String sql = "select * from userCourse where username =?";
        return template.query(sql, new BeanPropertyRowMapper<>(UserCourse.class), user.getUsername());
    }

    @Override
    public List<String> searchCourseData(String search) {
        String sql = "select courseName from course where courseName like ?";
        return template.query(sql, new BeanPropertyRowMapper<>(String.class), "%"+search+"%");
    }

    @Override
    public List<String> searchExperienceData(String search) {
        String sql = "select theme from experience where theme like ?";
        return template.query(sql, new BeanPropertyRowMapper<>(String.class), "%"+search+"%");
    }

    @Override
    public List<String> searchShopData(String search) {
        String sql = "select shopName from shop where courseName like ?";
        return template.query(sql, new BeanPropertyRowMapper<>(String.class), "%"+search+"%");    }

    @Override
    public List<Course> searchCourse(String search) {
        String sql = "select * from course where coureseName like ?";
        return template.query(sql,new BeanPropertyRowMapper<>(Course.class),"%"+search+"%");
    }

    @Override
    public List<Experience> searchExperience(String search) {
        String sql = "select * from Experience where theme like ?";
        return template.query(sql,new BeanPropertyRowMapper<>(Experience.class),"%"+search+"%");
    }

    @Override
    public List<Shop> searchShop(String search) {
        String sql = "select * from Shop where ShopName like ?";
        return template.query(sql,new BeanPropertyRowMapper<>(Shop.class),"%"+search+"%");
    }
    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    @Override
    public void update(User user) {
        //1.定义sql
        String sql = "insert into user (nickname,password,email,gender,grade,phone,status,code) values(?,?,?,?,?,?,?,?)";
        //2.执行sql

        template.update(sql, user.getUsername(),
                user.getPassword()
        );
    }

    /**
     * 通过邮箱和密码查询用户
     *
     * @param email
     * @param password
     * @return
     */

    @Override
    public User findByUsernameOrEmailAndPassword(User user) {
        User u = null;
        try {
            //1.定义sql
            String sql = "select * from user where email = ? or username =? and password = ?";
            //2.执行sql
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), user.getEmail(), user.getUsername(), user.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return u;
    }


    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        User u = new User();

    }

}
