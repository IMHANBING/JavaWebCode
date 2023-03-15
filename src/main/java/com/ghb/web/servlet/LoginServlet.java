package com.ghb.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// response重定向
@WebServlet(name = "LoginSerlvet", value = "/loginservlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        // 用HttpServletRequest对象的getParameter()方法获取用户名和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 假设用户名和密码分别为：admin和123
        if (("admin").equals(username) && ("123").equals(password)) {
            // 如果用户名和密码正确，重定义回 welcome.html
            resp.sendRedirect("/myweb/welcome.html");
        } else {
            // 如果用户名和密码错误，重定向到login.html
            resp.sendRedirect("/myweb/login.html");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
