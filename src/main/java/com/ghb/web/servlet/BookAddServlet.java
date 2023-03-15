package com.ghb.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "BookAddServlet", urlPatterns = "/bookadd")
public class BookAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("utf-8");
        //1 接收表单传过来的数据
        String bookId = req.getParameter("bookId");
        String bookName = req.getParameter("bookName");
        String bookPrice = req.getParameter("bookPrice");
        //2 TODO：保存到数据库
        //2 把接收到数据重新转发到book_info页面
        req.setAttribute("bookId", bookId);
        req.setAttribute("bookName", bookName);
        req.setAttribute("bookPrice", bookPrice);
        //通过RequestDispatcher转发到一个jsp页面
        req.getRequestDispatcher("/jsp/book/book_info.jsp").
                forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }
}
