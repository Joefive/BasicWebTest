package com.sunrise.jdbc;

import com.sunrise.domain.Emp;
import com.sunrise.utils.JdbcUtils;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcDemo07 {
    /**
     * 测试主方法
     * @param args
     */
    public static void main(String[] args) {
        List<Emp> all = new JdbcDemo07().findAllTwo();
        System.out.println(all);
        System.out.println(all.size());
    }
    /**
     * 查询所有emp对象
     *
     * @return
     */
    public List<Emp> findAllTwo() {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        List<Emp> list = null;
        try {
            conn = JdbcUtils.getConnect();
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
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.Close(rs,stat,conn);
        }
        return list;
    }
}
