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
import java.util.List;
import java.util.Map;

/**
 * 进行脑部数据
 */
@WebServlet("/searchData")
public class SearchData extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得传过来的数据
        String search = request.getParameter("search");
        String type = request.getParameter("type");
        //创建userService,搜素数据
        UserService service = new UserServiceImpl();
        List<String> list = service.searchData(search, type);
        //初始化传输值
        ResultInfo info = new ResultInfo();
        info.setData(list);
        //返回结果
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(), info);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
