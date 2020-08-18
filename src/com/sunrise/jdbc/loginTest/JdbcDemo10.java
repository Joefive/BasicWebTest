package com.sunrise.jdbc.loginTest;

import com.sunrise.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 使用事务操作数据库
 * conn对象使用setAutoCommit()方法进行开启事务，false开启，默认关闭
 * 程序结尾进行提交conn.
 */
public class JdbcDemo10 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        try {
            //获取连接
            conn = JdbcUtils.getConnect();
            //开启事务
            conn.setAutoCommit(false);
            //账号1转账转出500元
            String sql1 = "UPDATE ACCOUNT SET BALANCE = BALANCE-? WHERE ID=?";
            //账号2收到500元
            String sql2 = "UPDATE ACCOUNT SET BALANCE = BALANCE+? WHERE ID=?";
            pstmt1 = conn.prepareStatement(sql1);
            pstmt2 = conn.prepareStatement(sql2);
            //设置参数值
            pstmt1.setDouble(1, 500);
            pstmt1.setInt(2, 1);
            pstmt2.setDouble(1, 500);
            pstmt2.setInt(2, 2);
            //执行SQL
            pstmt1.executeUpdate();
            //手动制造异常
            //int i = 3/0;
            pstmt2.executeUpdate();
            //提交事务
            conn.commit();
            System.out.println("事务提交成功");

        } catch (Exception e) {
            try {
                if (conn != null) {
                    conn.rollback();
                    System.out.println("事务回滚...!");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JdbcUtils.Close(pstmt1, conn);
            JdbcUtils.Close(pstmt2, null);
        }
    }
}
