package com.ghb.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ResultServlet", value = "/ResultServlet")
public class ResultServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
// 获取PrintWriter对象用于输出信息
        PrintWriter out = resp.getWriter();
// 获取request请求对象转发过来的数据
        String students = req.getParameter("student");
        String schoolName = req.getParameter("schoolName");
        String address = req.getParameter("address");
        if (students != null) {
            out.println("这些内容是ResultServlet输出到浏览器的:<br>");
            out.println("学校名称：" + schoolName + "<br>");
            out.println("学校地址：" + address + "<br>");
            out.println("学生人数：" + students + "<br>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
