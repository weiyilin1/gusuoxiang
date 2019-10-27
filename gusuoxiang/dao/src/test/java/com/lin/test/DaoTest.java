package com.lin.test;

import com.lin.dao.UserCourseDao;
import com.lin.dao.UserDao;
import com.lin.dao.impl.UserCourseDaoImpl;
import com.lin.dao.impl.UserDaoImpl;
import com.lin.domain.User;


public class DaoTest {
    public static void main(String[] args) {
//        UserCourseDao dao = new UserCourseDaoImpl();
//        User user = new User();
//        user.setCode("79a801051e364e2491a5fd4aec2e4565");
//        String courseType = "吉他";
//        dao.insertUserCourse(user, courseType);

        UserDao userDao = new UserDaoImpl();
        User user = new User();
        userDao.update(user);


    }




}
