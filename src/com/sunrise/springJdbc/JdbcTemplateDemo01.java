package com.sunrise.springJdbc;

import com.sunrise.utils.DruidUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Spring中JDBCTemplate
 */
public class JdbcTemplateDemo01 {
    public static void main(String[] args) {
        //1.导入JAR包；
        //2.创建JDBCTemplate对象；
        JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());
        //3.创建SQL语句
        String sql = "UPDATE ACCOUNT SET BALANCE='100' WHERE ID=? AND NAME=?";
        //4.对象执行update方法
        int count = template.update(sql, 1, "韩司");
        System.out.println(count);
    }
}
