package com.sunrise.dataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 数据库连接池java提供了标准接口DataSource，由厂商来实现，javax.sql包下面
 * 连接池中close()代表归还连接，不是关闭连接
 * 常用技术：C3P0,Druid阿里连接池
 * C3P0技术:1.导包；2.加入xml配置文件；3.创建核心对象ComboPooledDataSource;4.获取连接对象getConnection()；
 */
public class DataSource01 {
    public static void main(String[] args) throws SQLException {
        //创建数据库连接池对象,父类引用创建子类对象，多态；
        DataSource ds = new ComboPooledDataSource();
        //没有传参数使用xml中默认配置，如果传参数使用对应配置标签名称“<named-config name="otherc3p0"> ”
        //DataSource ds = new ComboPooledDataSource("otherc3p0");
        /**
         * 验证最大连接数及close()归还方法
         * 连接ID等于5的时候
         */
        for (int i = 1; i <= 10; i++) {
            //获取连接对象
            Connection conn = ds.getConnection();
            System.out.println(i + ":" + conn);
            if (i==5){
                conn.close();
            }
        }

    }
}
