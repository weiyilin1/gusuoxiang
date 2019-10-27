package com.lin.controller.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lin.domain.CourseNote;
import com.lin.domain.User;
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
 * 查询用户自己写的课程笔记
 */
@WebServlet("/findUserNote")
public class FindUserNote extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //得到用户信息
        User user = (User) request.getSession().getAttribute("user");
        //创建userService，获得用户信息
        UserService service = new UserServiceImpl();
        List<CourseNote> courseNote = service.findUserNote(user);

        //返回结果
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(), courseNote);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
