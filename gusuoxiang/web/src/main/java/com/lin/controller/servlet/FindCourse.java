package com.lin.controller.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lin.domain.Course;
import com.lin.service.CourseService;
import com.lin.service.UserService;
import com.lin.service.impl.CourseServiceImpl;
import com.lin.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 通过页数进行查询课程
 */
@WebServlet("/findCourse")
public class FindCourse extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得传过来的页数
        String page = request.getParameter("page");
        //创建userService，得到list<Course>
        CourseService service = new CourseServiceImpl();
        List<Course> courses = service.findCourse(page);
        //返回结果
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(), courses);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
