package com.lin.controller.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lin.service.UserService;
import com.lin.service.impl.UserServiceImpl;
import com.lin.utils.ResultInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 检验邮箱是否可用
 */
@WebServlet("/checkEmail")
public class CheckEmail extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //获得用户输入的邮箱
        String email = request.getParameter("email");
        //创建userService
        UserService userService = new UserServiceImpl();
        //判断该邮箱是否被注册过
        // 如果结果为true 可以使用注册
        //如果结果为false  不可以注册
        boolean flag = userService.checkEmail(email);
        //初始化传输值
        ResultInfo info = new ResultInfo();
        info.setFlag(flag);
        //返回结果
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(), info);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
