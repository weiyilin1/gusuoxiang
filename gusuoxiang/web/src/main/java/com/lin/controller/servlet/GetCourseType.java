package com.lin.controller.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lin.domain.User;
import com.lin.service.UserService;
import com.lin.service.impl.UserServiceImpl;
import com.lin.utils.ResultInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 获得用户选择了什么课程
 */
@WebServlet("/getCourseType")
public class GetCourseType extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //如果用户还没有登录，查询cookie  如果用户登陆了，查询数据库表
        User user = (User) request.getSession().getAttribute("user");
        List<String> list = new ArrayList<>();
        if (user == null) {
            //查询cookies
            Cookie[] cookies = request.getCookies();
            //遍历获得cookie
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    String cookieName = cookie.getName();
                    //排除其他cookie的影响
                    if (cookieName.indexOf("courseType") != -1) {
                        String courseType = cookie.getName();
                        list.add(courseType);
                    }
                }
            }
        }else{
            //创建userService，获得选择的课程列表
            UserService userService = new UserServiceImpl();
            list = userService.getUserCourseType(user);
        }
        //初始化传输值
        ResultInfo info = new ResultInfo();
        info.setData(list);
        //返回结果
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(), info);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
