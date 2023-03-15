package com.ghb.web.servlet.car;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

@WebServlet(name = "ProductListServlet", urlPatterns = "/ProductListServlet")
public class ProductListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        Collection<Product> products = ProductDB.getAll();

        PrintWriter out = resp.getWriter();

        out.println("商品列表: <a href='/CarServlet'>查看购物车</a><br>");

        for (Product product : products) {
            String url = "/PurchaseServlet?id=" + product.getId();
            out.println(product.getName() + "<a href='" + url + "'>放入购物车</a><br>");
        }

    }
}
