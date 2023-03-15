package com.ghb.web.user.dao;

import com.ghb.web.user.model.User;
import com.ghb.web.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    // 查询所有用户
    public List<User> findAll() {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<User> list = new ArrayList<>();

        try {

            conn = JDBCUtil.getConnection();

            String sql = "select * from user";

            stmt = conn.createStatement();

            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUserName(rs.getString("user_name"));
                user.setSex(rs.getString("sex"));
                user.setClazz(rs.getString("clazz"));
                user.setUserNo(rs.getString("user_no"));
                list.add(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(rs, stmt, conn);
        }

        return list;

    }

    public void add(User user) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {

            conn = JDBCUtil.getConnection();
            String sql = "insert into user(user_name,sex,clazz,user_no) values(?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getUserName());
            stmt.setString(2, user.getSex());
            stmt.setString(3, user.getClazz());
            stmt.setString(4, user.getUserNo());
            stmt.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(null, stmt, conn);
        }
    }

    public void update(User user) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {

            conn = JDBCUtil.getConnection();
            String sql = "update user set user_name=?,sex=?,clazz=?,user_no=? where user_id=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getUserName());
            stmt.setString(2, user.getSex());
            stmt.setString(3, user.getClazz());
            stmt.setString(4, user.getUserNo());
            stmt.setInt(5, user.getUserId());
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(null, stmt, conn);
        }
    }

    public void delete(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {

            conn = JDBCUtil.getConnection();
            String sql = "delete from user  where user_id=?";
            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(null, stmt, conn);
        }
    }

    public User find(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User user = new User();

        try {

            conn = JDBCUtil.getConnection();
            String sql = "select * from user  where user_id=?";

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                user.setUserId(rs.getInt("user_id"));
                user.setUserName(rs.getString("user_name"));
                user.setSex(rs.getString("sex"));
                user.setClazz(rs.getString("clazz"));
                user.setUserNo(rs.getString("user_no"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(null, stmt, conn);
        }
        return user;
    }

}
