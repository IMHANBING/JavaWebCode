package com.ghb.web.util;

import java.sql.*;

public class JDBCUtil {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2.创建连接
        String url = "jdbc:mysql://localhost:3306/mydatabase?serverTimezone=Asia/Shanghai&autoReconnect=true&useSSL=false&characterEncoding=utf8&useUnicode=true";
        String username = "root";
        String password = "011217";

        Connection conn = DriverManager.getConnection(url, username, password);

        return conn;
    }

    public static void release(ResultSet rs,
                               Statement stmt,
                               Connection conn) {
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
