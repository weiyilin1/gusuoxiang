package com.lin.service.impl;


import com.lin.dao.CourseDao;
import com.lin.dao.ExperienceDao;
import com.lin.dao.UserCourseDao;
import com.lin.dao.UserDao;
import com.lin.dao.impl.CourseDaoImpl;
import com.lin.dao.impl.ExperienceDaoImpl;
import com.lin.dao.impl.UserCourseDaoImpl;
import com.lin.dao.impl.UserDaoImpl;
import com.lin.domain.*;
import com.lin.service.UserService;
import com.lin.utils.MailUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.Cookie;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

@SuppressWarnings("all")
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();
    private UserCourseDao userCourseDao = new UserCourseDaoImpl();

    /**
     * 注册账号
     *
     * @param user
     * @return
     */
    @Override
    public boolean register(Map<String, String[]> map, String code) {
        //封装对象
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        String checkcode = map.get(code)[0].toString();
        if (checkcode == code) {
            userDao.saveUser(user);
            return true;
        }else {
            return false;

        }


    }

    /**
     * 登录
     * @param user
     * @return
     */
    @Override
    public User login(Map<String, String[]> map) {
        //封装对象
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        User u = userDao.findByUsernameOrEmailAndPassword(user);
        return u;
    }

    /**
     * 查询用户选择的课程
     * @param user
     * @return
     */
    @Override
    public List<String> getUserCourseType(User user) {
        if (user != null) {
            List<String> courseTypes = new ArrayList<>();
            List<UserCourse> list = userDao.getUserCourseType(user);
            for (UserCourse userCourse : list) {
                courseTypes.add(userCourse.getCourseType());
            }
            return courseTypes;
        } else {
            return null;
        }
    }

    /**
     * 发送邮件
     * @param email
     * @return
     */

    @Override
    public String sendCode(String email) {
        String code = getCheckCode();
        MailUtils.sendMail(email,
                "亲爱的用户：<br> 本次的邮箱验证码为：<a href='#'>" +
                         ""+code+
                        "</a> （验证码在10分钟内有效）<br>如果这不是您的邮件，请忽略此邮件。<br>沽所向系统邮件，请勿回复。",
                "验证码");
        return code;

    }

    /**
     * 检验邮箱
     * @param email
     * @return
     */
    @Override
    public boolean checkEmail(String email) {
        User user = userDao.findByEmail(email);
        if (user == null) {//邮箱可用
            return true;
        }
        return false;
    }

    /**
     * 校验用户名
     * @param username
     * @return
     */
    @Override
    public boolean checkUsername(String username) {
        User user = userDao.findByUsername(username);
        if (user == null) {//邮箱可用
            return true;
        }
        return false;
    }

    /**
     * 获得用户课程笔记
     * @param user
     * @return
     */
    @Override
    public List<CourseNote> findUserNote(User user) {
        return userDao.findUserNote(user);
    }

    /**
     * 获得用户的经验
     * @param user
     * @return
     */

    @Override
    public List<Experience> findUserExperience(User user) {
        return userDao.findUserExperience(user);
    }

    /**
     *查询用户收藏的课程
     * @param user
     * @return
     */
    @Override
    public List<UserCollectCourse> findCollectCourse(User user) {
        return userDao.findCollectCourse(user);

    }

    /**
     * 查询用户收藏的经验
     * @param user
     * @return
     */
    @Override
    public List<UserCollectExperience> findCollectExperience(User user) {
        return userDao.findCollectExperience(user);
    }

    /**
     * 用户选择专题
     * @param user
     * @param map
     */
    @Override
    public  List<Cookie> chooseCourse(User user, Map<String, String[]> map) {
        if (user == null) {
            //获得传过来的目标的个数
            int size = Integer.parseInt(map.get("size")[0].toString());
            //初始化传输过去到接口，保存到客户端
            List<Cookie> cookies = new ArrayList<>();
            //循环遍历，获得传过来的所有目标的值
            for (int i = 1; i < size; i++) {
                //传过来的json值为courseType1，courseType2，courseType3...
                String courseType = map.get("courseType" + i)[0].toString();
                //保存
                Cookie cookie = new Cookie("courseType" + i, courseType);
                cookies.add(cookie);
            }
            return cookies;
        }else{

            //获得传过来的目标的个数
            int size = Integer.parseInt(map.get("size")[0].toString());
            //获得用户名
            String username = user.getUsername();
            UserCourse course = new UserCourse();
            //循环遍历，获得传过来的所有目标的值
            for (int i = 1; i < size; i++) {
                //传过来的json值为courseTitle1，courseTitle2，courseTitle3...
                String courseTitle = map.get("courseTitle" + i)[0].toString();
                //传过来的json值为courseType1，courseType2，courseType3...
                String courseType = map.get("courseType" + i)[0].toString();
                //给course赋值
                course.setCourseTitle(courseTitle);
                course.setCourseType(courseType);
                course.setUsername(username);
                //向数据库添加用户课程
                userDao.addUserCourse(course);
            }
            return null;
        }
    }

    /**
     * 收藏视频
     * @param user
     * @param map
     * @return
     */
    @Override
    public boolean collectCourse(User user, Map<String, String[]> map) {
        //如果用户存在，可以收藏，返回true，用户不存在，不可以收藏，返回false

        if (user != null) {
            //创建用户收藏课程表
            UserCollectCourse collectCourse = new UserCollectCourse();
            try {
                BeanUtils.populate(collectCourse, map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            //得到用户名
            String username = user.getUsername();
            collectCourse.setUsername(username);
            //收藏时间
            collectCourse.setCourseCollectTime(new Date());
            CourseDao courseDao = new CourseDaoImpl();
            //将数据添加到用户收藏表中
            courseDao.collectCourse(collectCourse);
            courseDao.updateCollectNumber(Integer.parseInt(map.get("id")[0].toString()));

            return true;
        }else {
            return false;
        }
    }

    /**
     * 收藏经验
     * @param user
     * @param map
     * @return
     */
    @Override
    public boolean collectExperience(User user, Map<String, String[]> map) {
        //如果用户存在，可以收藏，返回true，用户不存在，不可以收藏，返回false
        if (user != null) {
            //创建UserCollectExperience
            UserCollectExperience collectExperience = new UserCollectExperience();
            try {
                //把传过来map赋值到UserCollectExperience上
                BeanUtils.populate(collectExperience, map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            //获得用户名
            String username = user.getUsername();
            collectExperience.setUsername(username);
            //用户收藏经验的时间
            collectExperience.seteCollectTime(new Date());
            ExperienceDao experienceDao = new ExperienceDaoImpl();
            //将数据添加到用户收藏表中
            experienceDao.collectExperience(collectExperience);
            experienceDao.updateCollectNumber(Integer.parseInt(map.get("id")[0].toString()));


            return true;
        }else {
            return false;
        }    }

    /**
     * 搜索栏给查询的数据，脑部十条数据
     * @param search
     * @param type
     * @return
     */
    @Override
    public List<String> searchData(String search, String type) {
        List<String> list = new ArrayList<>();
        if (type == "course") {
            List<String> list1= userDao.searchCourseData(search);
            if (list1.size() > 10) {
                for (int i = 0; i < 10; i++) {
                    list.add(list1.get(i));
                }
            }else {
                list = list1;
            }
            return list;

        } else if (type == "experience") {
            List<String> list1= userDao.searchExperienceData(search);
            if (list1.size() > 10) {
                for (int i = 0; i < 10; i++) {
                    list.add(list1.get(i));
                }
            }else {
                list = list1;
            }
            return list;
        } else if (type == "shop") {
            List<String> list1= userDao.searchShopData(search);
            if (list1.size() > 10) {
                for (int i = 0; i < 10; i++) {
                    list.add(list1.get(i));
                }
            }else {
                list = list1;
            }
            return list;
        } else {
            return null;
        }
    }

    /**
     * 搜索课程
     * @param search
     * @return
     */
    @Override
    public List<Course> searchCourse(String search) {
        return userDao.searchCourse(search);
    }

    /**
     * 搜索经验
     * @param search
     * @return
     */
    @Override
    public List<Experience> searchExperience(String search) {
        return userDao.searchExperience(search);
    }

    /**
     * 搜索商品
     * @param search
     * @return
     */
    @Override
    public List<Shop> searchShop(String search) {
        return userDao.searchShop(search);
    }


    /**
     * 产生4位随机字符串
     */
    private String getCheckCode() {
        String base = "0123456789";
        int size = base.length();
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        for(int i=1;i<=4;i++){
            //产生0到size-1的随机值
            int index = r.nextInt(size);
            //在base字符串中获取下标为index的字符
            char c = base.charAt(index);
            //将c放入到StringBuffer中去
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        UserService service = new UserServiceImpl();
//        String code = service.sendCode("1468494508@qq.com");
//        System.out.println(code);

        Map<String, String[]> map = new HashMap<>();
        map.put("username", new String[]{"zhangsan"});
        map.put("password", new String[]{"zhangsan"});
        map.put("code", new String[]{"1234"});
//        2.封装对象
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        String code = "1234";
        String[] codes = map.get("code");
        System.out.println(codes[0].toString() == code);


    }


}
