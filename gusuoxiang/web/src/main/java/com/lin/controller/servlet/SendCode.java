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
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 发送验证码
 */
@WebServlet("/sendCode")
public class SendCode extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得邮箱
        String email = request.getParameter("email");
        //创建userService
        UserService service = new UserServiceImpl();
        //发送邮件验证码，进行子线程发送，不影响显示
        new Thread(){
            @Override
            public void run() {
                super.run();
               String code= service.sendCode(email);
               //保存数据到session,设置保存时间
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(10 * 60);
                session.setAttribute("code", code);
            }
        }.start();
        //初始化传输值
        ResultInfo info = new ResultInfo();
        info.setFlag(true);
        //返回结果
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(), info);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
