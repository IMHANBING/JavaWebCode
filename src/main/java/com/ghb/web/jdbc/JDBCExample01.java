package com.ghb.web.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCExample01 {
    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2.创建连接
            String url = "jdbc:mysql://localhost:3306/mydatabase?serverTimezone=Asia/Shanghai&autoReconnect=true&useSSL=false&characterEncoding=utf8&useUnicode=true";
            String username = "root";
            String password = "011217";

            conn = DriverManager.getConnection(url, username, password);

            // 3.创建Statement对象
            stmt = conn.createStatement();

            // 4.执行sql语句
//            String sql = "insert into user(user_name,sex,clazz,user_no)" +
//                    " values('柳智敏','0','2003','20010608')";
//            stmt.executeUpdate(sql);

            String sql = "select * from user";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int userId = rs.getInt("user_id");
                String userName = rs.getString("user_name");
                String sex = rs.getString("sex");
                String clazz = rs.getString("clazz");
                String userNo = rs.getString("user_no");
                //打印出获得的数据
                System.out.println(userId + " | " + userName + " | " + sex + " | " + clazz + " | " + userNo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
