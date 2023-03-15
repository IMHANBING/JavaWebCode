package com.ghb.web.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// Servlet生命周期方法
@WebServlet(name = "ThirdServlet", urlPatterns = "/thirdservlet")
public class ThirdServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        //每次请求时被调用
        System.out.println("doPost 方法被调用");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //每次请求时被调用
        System.out.println("doGet方法被调用");
        doPost(req, resp);
    }

    //第一次访问时被调用
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("初始化方法init()被调用");
    }

    //Web容器关闭时被调用,或者垃圾收集器回收时被调用
    public void destroy() {
        System.out.println("销毁方法 destroy() 被调用");
    }
}
