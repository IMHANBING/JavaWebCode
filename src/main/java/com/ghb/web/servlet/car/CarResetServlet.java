package com.ghb.web.servlet.car;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "CarResetServlet", value = "/CarResetServlet")
public class CarResetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获得用户的会话session
        HttpSession session = req.getSession(false);
        // 如果session不为null
        if (session != null) {
            //可以从购物车里面取出商品进行结算处理
            //可以直接清空购物车
            session.removeAttribute("car");
        }
        //返回购物车
        resp.sendRedirect("/CarServlet");
    }
}
