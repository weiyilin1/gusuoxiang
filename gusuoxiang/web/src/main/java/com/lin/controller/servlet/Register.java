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
import java.util.Map;

@SuppressWarnings("all")
/**
 * 用户注册
 */
@WebServlet("/register")
public class Register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取传过来的数据
        Map<String, String[]> map = request.getParameterMap();
        //创建userService对象
        UserService service = new UserServiceImpl();
        /**
         *  进行注册
         *      true ：注册成功
         *      false：注册失败
         */
        boolean flag=service.register(map,(String)request.getSession().getAttribute("code"));
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
