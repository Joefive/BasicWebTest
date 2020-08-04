package com.sunrise.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcDemo02 {
    public static void main(String[] args) throws Exception {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3308/db1?serverTimezone=UTC","root","root");
            Statement st = conn.createStatement();
            boolean execute = st.execute("SELECT * FROM ACCOUNT WHERE ID='1'");
            System.out.println(execute);
            ResultSet resultSet = st.executeQuery("SELECT * FROM ACCOUNT WHERE ID='1'");

    }
}
