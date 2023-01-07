package com.example.adro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnect {
    public void insertData(String sqlText) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/adro", "root","");
        Statement statement = con.createStatement();
        if (statement.executeUpdate(sqlText)>0){
            System.out.println("Successfully added!");
        }else{
            System.out.println("Something went wrong!!!");
        }
    }
}
