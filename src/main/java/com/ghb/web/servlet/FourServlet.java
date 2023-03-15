package com.ghb.web.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//通过loadOnStartup参数,自动启动Servlet
@WebServlet(name = "FourServlet", value = "/fourservlet", loadOnStartup = 2)
public class FourServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    //第一次访问时被调用
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("FourServlet 的 初始化方法 init() 被调用");
    }
}
