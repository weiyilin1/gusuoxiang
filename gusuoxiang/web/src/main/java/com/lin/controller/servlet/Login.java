package com.lin.controller.servlet;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.lin.domain.User;
import com.lin.service.UserService;
import com.lin.service.impl.UserServiceImpl;
import com.lin.utils.ResultInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
@SuppressWarnings("all")
/**
 * 用户登录
 */
@WebServlet("/login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取邮箱和密码数据
        Map<String, String[]> map = request.getParameterMap();
        //创建userService
        UserService service = new UserServiceImpl();
        /**
         * 调用登录方法
         *      true 登录成功
         *      false 登录失败 提示登录失败，判断用户名或密码是否正确
         *      登录成功把user保存到session，以后的一些用户的操作，需要用到user的话
         *      直接从session的获取，可以形成用户拦截的效果
         */
        User u = service.login(map);
        request.getSession().setAttribute("user", u);
        boolean flag;
        if (u != null) {
            flag = true;
        } else {
            flag = false;
        }
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
