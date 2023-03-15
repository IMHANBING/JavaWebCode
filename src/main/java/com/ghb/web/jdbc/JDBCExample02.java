package com.ghb.web.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCExample02 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement preStmt = null;
        try {
            // 1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2.创建连接
            String url = "jdbc:mysql://localhost:3306/mydatabase?serverTimezone=Asia/Shanghai&autoReconnect=true&useSSL=false&characterEncoding=utf8&useUnicode=true";
            String username = "root";
            String password = "011217";

            conn = DriverManager.getConnection(url, username, password);

            // 3.
            String sql = "insert into user(user_name,sex,clazz,user_no) values(?,?,?,?)";
            preStmt = conn.prepareStatement(sql);

            for (int i = 1; i < 10; i++) {
                preStmt.setString(1, "ITZY" + i);
                preStmt.setString(2, "0");
                preStmt.setString(3, "2003");
                preStmt.setString(4, "20881156" + i);

                preStmt.executeUpdate();
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
            if (preStmt != null) {
                try {
                    preStmt.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
