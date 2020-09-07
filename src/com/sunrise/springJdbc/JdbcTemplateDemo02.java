package com.sunrise.springJdbc;

import com.sunrise.domain.Emp;
import com.sunrise.utils.DruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
        methodFour(1);
        methodFive();
        methodSix();
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

    /**
     * 需求4，查询ID为1的数据并封装到MAP集合中
     * 查询长度只能为1，只能查询出1行数据，列=key，值=value
     */
    public static void methodFour(int numId) {
        String sql = "SELECT * FROM EMP WHERE ID=?";
        Map<String, Object> stringObjectMap = template.queryForMap(sql, numId);
        System.out.println("stringObjectMap : " + stringObjectMap);
        System.out.println("**********需求4执行完成**********");
    }

    /**
     * 需求5，查询出一张表所有数据封装到LIST集合中
     * 每行数据封装成MAP集合，再将所有的MAP集合封装到
     */
    public static void methodFive() {
        String sql = "SELECT * FROM EMP";
        List<Map<String, Object>> list = template.queryForList(sql);
        int count = 1;
        for (Map<String, Object> stringObjectMap : list) {
            System.out.println("第" + count + "行:" + stringObjectMap);
            count++;
            System.out.println("**********需求5执行完成需求5执行完成**********");
        }
    }

    /**【复杂版】
     * 需求6，查询结果封装到Bean中然后再次封装到List中
     */
    public static void methodSix() {
        String sql = "SELECT * FROM EMP";
        //传递sql，传递封装对象
        List<Emp> queryList = template.query(sql, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet resultSet, int i) throws SQLException {
                Emp emp = new Emp();
                int id = emp.getId();
                String name = emp.getName();
                double salary = emp.getSalary();
                String gender = emp.getGender();
                Date join_date = emp.getJoin_date();
                int dept_id = emp.getDept_id();

                emp.setId(id);
                emp.setDept_id(dept_id);
                emp.setJoin_date(join_date);
                emp.setSalary(salary);
                emp.setGender(gender);
                emp.setName(name);

                return emp;
            }
        });
        for (Emp emp : queryList) {
            System.out.println(emp);
        }
    }

    /**【简化版】
     * 需求6，调用BeanPropertyRowMapper实现类，省略Bean中复杂的get与set方法
     */

    public static void methodSixSimple(){
        String sql = "SELECT * FROM EMP";

    }
}
