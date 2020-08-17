package com.sunrise.utils;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * 抽取JDBC工具类
 */

public class JdbcUtils {
    private static String dirver;
    private static String url;
    private static String user;
    private static String password;

    /**
     * 读取静态代码块，获取配置文件信息
     */
    static {
        //Properties集合类后去配置文件值
        try {
            Properties pro = new Properties();
            //classloader类加载器
            ClassLoader classLoader = JdbcUtils.class.getClassLoader();
            URL res = classLoader.getResource("db.properties");
            String path = res.getPath();
            System.out.println(path);
            pro.load(new FileReader(path));
            //pro.load(new FileReader("src/db.properties"));
            dirver = pro.getProperty("dirver");
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            //注册驱动
            Class.forName(dirver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取连接，使用配置文件方式
     *
     * @return 连接对象
     */
    public static Connection getConnect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * 释放资源方式重载
     *
     * @param stat
     * @param conn
     */
    public static void Close(Statement stat, Connection conn) {
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

    /**
     * 释放连接方法重载
     *
     * @param rs
     * @param stat
     * @param conn
     */
    public static void Close(ResultSet rs, Statement stat, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
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
