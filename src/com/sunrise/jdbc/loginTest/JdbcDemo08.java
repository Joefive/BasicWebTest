package com.sunrise.jdbc.loginTest;

import com.sunrise.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * 用户登录联系
 * 键盘输入用户名密码，如果正确返回登录成功
 */
public class JdbcDemo08 {
    //测试主方法
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String userName = sc.nextLine();
        System.out.println("请输入密码：");
        String passWord = sc.nextLine();
        //调用方法
        Boolean flag = new JdbcDemo08().login(userName, passWord);
        //判断是否登录成功
        if (flag) {
            System.out.println("大佬，您登录成功了！");
        } else {
            System.out.println("仓鼠您输入用户名或密码错误！");
        }
    }

    public Boolean login(String userName, String passWord) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        if (userName == null || passWord == null) {
            return false;
        }
        try {
            conn = JdbcUtils.getConnect();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM USER ");
            sql.append("WHERE USERNAME='" + userName + "' AND PASSWORD='" + passWord + "'");
            stmt = conn.createStatement();
            rs = stmt.executeQuery(String.valueOf(sql));
            System.out.println(sql);
            //判断输入，如果有下一行确定存在返回true反之返回false
            //rs.next()返回的本来就是true|false
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.Close(rs, stmt, conn);
        }
        return false;
    }
}
