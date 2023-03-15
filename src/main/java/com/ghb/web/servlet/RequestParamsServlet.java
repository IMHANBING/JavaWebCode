package com.ghb.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//通过request对象,接收页面发送的数据
@WebServlet(name = "RequestParamsServlet", value = "/RequestParamsServlet")
public class RequestParamsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置request对象的解码方式,处理中文
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("username");
        String password = req.getParameter("password");
        String sex = req.getParameter("sex");
        System.out.println("姓名:" + name);
        System.out.println("密码:" + password);
        System.out.println("性别:" + sex);
// 获取参数名为“hobby”的值
        String[] hobbys = req.getParameterValues("hobby");
        String hobby = "";
        System.out.print("爱好:");
        for (int i = 0; i < hobbys.length; i++) {
            System.out.print(hobbys[i] + ",");
            hobby = hobby + hobbys[i];
            System.out.println();
        }
//输出到浏览器
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println(
                "你输入的数据为:<br>" +
                        "姓名:" + name + "<br>" +
                        "密码:" + password + "<br>" +
                        "性别:" + sex + "<br>" +
                        "爱好:" + hobby + "<br>"
        );
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
