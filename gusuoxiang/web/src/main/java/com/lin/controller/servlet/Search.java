package com.lin.controller.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lin.domain.Course;
import com.lin.domain.Experience;
import com.lin.domain.Shop;
import com.lin.service.UserService;
import com.lin.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@SuppressWarnings("all")
/**
 * 点击查询的时候进行调用该方法
 */
@WebServlet("/search")
public class Search extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得传过来的数据
        String search = request.getParameter("search");
        String type = request.getParameter("type");
        //创建userService,搜素数据
        UserService service = new UserServiceImpl();
        ObjectMapper mapper = new ObjectMapper();
        //对类型进行分类查询
        if (type == "course") {
            List<Course> list = service.searchCourse(search);
            mapper.writeValue(response.getWriter(), list);
        } else if (type == "experience") {
            List<Experience> list = service.searchExperience(search);
            mapper.writeValue(response.getWriter(), list);

        } else if (type == "shop") {
            List<Shop> list = service.searchShop(search);
            mapper.writeValue(response.getWriter(), list);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
