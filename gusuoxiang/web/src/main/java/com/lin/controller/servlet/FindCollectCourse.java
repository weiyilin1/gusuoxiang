package com.lin.controller.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lin.domain.User;
import com.lin.domain.UserCollectCourse;
import com.lin.domain.UserCourse;
import com.lin.service.UserService;
import com.lin.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 查询自己收藏的课程
 */
@WebServlet("/findCollectCourse")
public class FindCollectCourse extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        //创建userService，获得用户信息
        UserService service = new UserServiceImpl();
        List<UserCollectCourse> userCourse = service.findCollectCourse(user);

        //返回结果
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(), userCourse);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
