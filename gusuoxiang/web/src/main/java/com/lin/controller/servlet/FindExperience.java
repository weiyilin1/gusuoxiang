package com.lin.controller.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lin.domain.Experience;
import com.lin.service.ExperienceService;
import com.lin.service.impl.ExperienceServiceImpl;
import com.lin.domain.Course;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 通过页数进行查询经验
 */
@WebServlet("/findExperience")
public class FindExperience extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得传过来的页数
        String page = request.getParameter("page");
        //创建userService，得到list<Course>
        ExperienceService service = new ExperienceServiceImpl();
        List<Experience> experiences = service.findExperience(page);
        //返回结果
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(), experiences);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
