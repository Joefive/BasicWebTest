package com.sunrise.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * 1.DriverManager对象：注册驱动、获取数据库连接
 * 2.Connection对象：数据库连接对象
 * 3.Statement对象：执行SQL对象
 * executeUpdate()方法，返回影响的行数
 *
 * 4.Result对象：结果集对象
 * 5.PreparedStatement对象：执行SQL对象
 */
public class JdbcDemo01 {
    public static void main(String[] args) throws Exception {
        //1.下载并导入驱动
        //2.注册驱动,注册mysql8版本驱动(可省略)
        Class.forName("com.mysql.cj.jdbc.Driver");
        //3.获取数据库连接对象
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/db1?serverTimezone=UTC", "root", "root");
        //4.定义sql语句
        String sql = "UPDATE ACCOUNT SET BALANCE='200' WHERE ID='1'";
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
