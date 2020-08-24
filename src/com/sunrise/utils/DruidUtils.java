package com.sunrise.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Druid工具类
 */
public class DruidUtils {
    private static DataSource ds;

    /**
     * 通过static代码块获取配置文件
     */
    static {
        Properties pro = new Properties();
        try {
            pro.load(DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取链接对象方法
     *
     * @return
     * @throws SQLException
     */
    public static Connection getConnect() throws SQLException {
        return ds.getConnection();
    }

    /**
     * 归还链接方法2个参数
     *
     * @param stmt
     * @param conn
     */
    public static void close(Statement stmt, Connection conn) {
        close(null,stmt,conn);
    }

    /**
     * 重载归还连接方法3个参数
     *
     * @param rs
     * @param stmt
     * @param conn
     */
    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
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

    public static DataSource getDataSource(){
        return ds;
    }
}
