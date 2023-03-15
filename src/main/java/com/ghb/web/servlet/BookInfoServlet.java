package com.ghb.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "BookInfoServlet", urlPatterns = "/bookinfo")
public class BookInfoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("bookId", "1001");
        req.setAttribute("bookName", "JavaWeb编程");
        req.setAttribute("bookPrice", "56.30");
//通过RequestDispatcher转发到一个jsp页面
        req.getRequestDispatcher("/jsp/book/book_info.jsp").
                forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
