package com.ghb.web.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "JstlServlet", urlPatterns = "/JstlServlet")
public class JstlServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("name", "张三");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/jstl.jsp");

        dispatcher.forward(req, resp);

    }
}
