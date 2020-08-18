package com.sunrise.jdbc.loginTest;


import com.sunrise.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * SQL注入问题：在SQL语句拼接的时候一些关键字参与拼接会出现安全问题
 * 例如：输入用户：ssdfa 密码：a' or 'a' ='a,会登陆成功
 * 使用PreparedStatement来解决，参数使用?来做占位符，使用setString()方法来传参数
 */
public class JdbcDemo09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String userName = sc.nextLine();
        System.out.println("请输入密码：");
        String passWord = sc.nextLine();
        Boolean flag = new JdbcDemo09().loginIn(userName, passWord);
        if(flag){
            System.out.println("登陆成功");
        }else{
            System.out.println("登陆失败");
        }

    }

    public Boolean loginIn(String userName, String passWord) {
        if (userName == null || passWord == null) {
            return false;
        }
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnect();
            String sql = "SELECT * FROM USER WHERE USERNAME=? AND PASSWORD=?";
            //PreparedStatement对象需要传递SQL语句
            pstmt = conn.prepareStatement(sql);
            //传入参数
            pstmt.setString(1, userName);
            pstmt.setString(2, passWord);
            //执行的时候不需要传递SQL
            rs = pstmt.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.Close(rs, pstmt, conn);
            System.out.println("资源释放成功...!");
        }

        //其他情况返回false
        return false;
    }

}
