package com.sunrise.dataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DataSource02_Druid {
    public static void main(String[] args) throws Exception {
        //1.添加jar包；2.定义配置文件
        //3.获取配置文件
        Properties pro = new Properties();
        InputStream is = DataSource02_Druid.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(is);
        //4.创建连接池对象
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        for (int i = 0; i < 10; i++) {
            //5.获取连接池对象
            Connection conn = ds.getConnection();
            System.out.println(i + ":" + conn);
            if (i == 5) {
                conn.close();
            }
        }

    }
}
