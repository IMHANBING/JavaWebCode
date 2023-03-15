package com.ghb.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//通过@WebServlet注解,声明servlet
@WebServlet(name = "SecondServlet", value = "/secondservlet")
public class SecondServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //输出中文
        resp.setContentType("text/html;charset=utf-8");
        //使用response响应浏览器的请求：返回简单文本
        resp.getWriter().print("使用注解方式创建的Servlet");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
