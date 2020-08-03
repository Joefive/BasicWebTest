package com.sunrise.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcDemo01 {
    public static void main(String[] args) throws Exception {
        //1.下载并导入驱动
        //2.注册驱动,注册mysql8版本驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //3.获取数据库连接对象
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/db1?serverTimezone=UTC", "root", "root");
        //4.定义sql语句
        String sql = "UPDATE ACCOUNT SET BALANCE='100' WHERE ID='1'";
        //5.获取sql对象的statment
        Statement stmt = con.createStatement();
        //6.执行sql
        int count = stmt.executeUpdate(sql);
        //7.处理结果
        System.out.println(count);
        //8.释放资源
        stmt.close();
        con.close();


    }
}
