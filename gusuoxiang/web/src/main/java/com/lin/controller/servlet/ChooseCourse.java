package com.lin.controller.servlet;

import com.lin.domain.User;
import com.lin.service.UserService;
import com.lin.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 选择课程
 */
@WebServlet("/chooseCourse")
public class ChooseCourse extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        //获取传过来的数据
        Map<String, String[]> map = request.getParameterMap();
        //创建userService对象
        UserService service = new UserServiceImpl();
        //获得cookies
        List<Cookie> list = service.chooseCourse(user, map);
        if (list != null) {
            //遍历，保存cookie
            for (Cookie cookie : list) {
                cookie.setMaxAge(60 * 60 * 24 * 365);
                response.addCookie(cookie);
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
