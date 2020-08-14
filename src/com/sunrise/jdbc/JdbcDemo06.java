package com.sunrise.jdbc;

import com.sunrise.domain.Emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcDemo06 {
    /**
     * 测试主方法
     * @param args
     */
    public static void main(String[] args) {
        List<Emp> all = new JdbcDemo06().findAll();
        System.out.println(all);
    }
    /**
     * 查询所有emp对象
     *
     * @return
     */
    public List<Emp> findAll() {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        List<Emp> list = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3308/db1?serverTimezone=UTC", "root", "root");
            //String sql = "SELECT * FROM EMP";
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM EMP WHERE ID");
            stat = conn.createStatement();
            rs = stat.executeQuery(sb.toString());
            Emp emp = null;
            list = new ArrayList<Emp>();
            while (rs.next()) {
                //取值
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                double salary = rs.getDouble("salary");
                Date join_date = rs.getDate("join_date");
                int dept_id = rs.getInt("dept_id");
                //创建emp对象
                emp = new Emp();
                emp.setId(id);
                emp.setName(name);
                emp.setGender(gender);
                emp.setSalary(salary);
                emp.setJoin_date(join_date);
                emp.setDept_id(dept_id);
                //装载集合
                list.add(emp);

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

}
