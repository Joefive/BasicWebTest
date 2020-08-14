package com.sunrise.jdbc;

import java.sql.*;

public class JdbcDemo05 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3308/db1?serverTimezone=UTC", "root", "root");
            String sql = "SELECT * FROM ACCOUNT";
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                int anInt = rs.getInt(1);
                String name = rs.getString("name");
                double aDouble = rs.getDouble(3);
                System.out.println("id:" + anInt + ",name:" + name + ",balance:" + aDouble);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
