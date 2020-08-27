package com.sunrise.springJdbc;

import com.sunrise.utils.DruidUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JdbcTemplate常用方法：
 * 1.update():执行增、删、改操作
 * 2.queryForMap():查询结果封装成Map
 * 3.queryForList():查询结果封装成List
 * 4.query()：查询结果，将结果封装到Bean中
 * 5.queryForObject():查询结果，将结果封装为对象
 */
public class JdbcTemplateDemo02 {
    private static JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());

    public static void main(String[] args) {
        methodOne(1);
        methodTwo();
        methodThree("白龙马");

    }

    /**
     * 需求1，添加人员
     *
     * @param numId
     */
    public static void methodOne(int numId) {
        String sql = "UPDATE EMP E SET E.SALARY='8000' WHERE E.ID=?";
        //放在方法中传递参数，使用的是PreparedStatement进行执行，有保障
        int count = template.update(sql, numId);
        if (count != 0) {
            System.out.println("方法methodOne执行成功！");
        } else {
            System.out.println("方法methodOne执行【失败】！");
        }
    }

    /**
     * 需求2，添加人员
     */
    public static void methodTwo() {
        String sql = "INSERT INTO EMP VALUES(NULL,?,?,?,SYSDATE(),?)";
        int count = template.update(sql, "白龙马", "男", "5000", "3");
        if (count != 0) {
            System.out.println("方法methodTwo执行成功！");
        } else {
            System.out.println("方法methodTwo执行【失败】！");
        }
    }

    /**
     * 需求3，删除刚才的添加人员
     */
    public static void methodThree(String delName) {
        String sql = "DELETE FROM EMP WHERE NAME=?";
        int count = template.update(sql, delName);
        if (count != 0) {
            System.out.println("方法methodThree执行成功！");
        } else {
            System.out.println("方法methodThree执行【失败】！");
        }
    }
}
