package com.ghb.web.servlet.car;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PurchaseServlet", urlPatterns = "/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        if (id == null) {
            // 如果id为null，重定向到ProductListServlet页面
            String url = "/ProductListServlet";
            resp.sendRedirect(url);
            return;
        }

        Product product = ProductDB.getProduct(id);


        HttpSession session = req.getSession(false);


        List<Product> car = (List) session.getAttribute("car");

        if (car == null) {
            car = new ArrayList<>();
        }

        car.add(product);

        session.setAttribute("car", car);

        resp.sendRedirect("/ProductListServlet");
    }
}
