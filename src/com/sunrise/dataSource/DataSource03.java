package com.sunrise.dataSource;

import com.sunrise.utils.DruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 使用Druid连接池对User表添加一条记录
 */
public class DataSource03 {
    public static void main(String[] args) {
        PreparedStatement pstmt = null;
        Connection conn = null;
        try {
            //1.获取连接
            conn = DruidUtils.getConnect();
            //2.定义SQL
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO USER VALUES (NULL,?,?)");
            //3.创建事务获取prepareStatement对象
            pstmt = conn.prepareStatement(String.valueOf(sql));
            //4.传入参数
            pstmt.setString(1, "scott");
            pstmt.setString(2, "scott");
            //5.执行SQL语句并返回成功行数
            int i = pstmt.executeUpdate();
            System.out.println("执行结果返回" + i + "条数据！");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtils.close(pstmt, conn);
        }
    }
}
