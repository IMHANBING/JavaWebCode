package com.ghb.web.servlet.car;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "CarServlet", urlPatterns = "/CarServlet")
public class CarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        // 用户的购物车
        List<Product> car = null;

        HttpSession session = req.getSession(false);
        // 如果session不为null
        if (session != null) {
            // 从session获得当前用户购物车
            car = (List) session.getAttribute("car");
            // 如果购物车不为null
            if (car != null) {
                // 显示用户购买商品的信息
                out.write("您购买的商品有：" +
                        "&nbsp;&nbsp;<a href='/ProductListServlet'>返回商品列表</a>" +
                        "&nbsp;&nbsp;<a href='/CarResetServlet'>清空购物车</a><br>");
                for (Product product : car) {
                    out.write(product.getName() + "<br>");
                }
            } else {
                // 如果购物车为null
                out.write("对不起！您还没有购买任何商品！" +
                        "&nbsp;&nbsp;<a href='/ProductListServlet'>返回商品列表</a><br>");
            }
        } else {
            // 如果session为null
            out.write("对不起！您还没有购买任何商品！" +
                    "&nbsp;&nbsp;<a href='/ProductListServlet'>返回商品列表</a><br>");
        }
    }
}
