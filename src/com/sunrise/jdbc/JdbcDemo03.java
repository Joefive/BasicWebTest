package com.sunrise.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo03 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.可以先定义sql
            String sql = "INSERT INTO ACCOUNT(ID,NAME,BALANCE) VALUES (NULL,'张二',2000)";
            //3.获取Connect对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3308/db1?serverTimezone=UTC", "root", "root");
            //4.获取Statement对象
            stat = conn.createStatement();
            int count = stat.executeUpdate(sql);
            System.out.println("执行结果：" + count);
            if (count > 0) {
                System.out.println("语句执行成功!");
            } else {
                System.out.println("语句执行失败！");
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
