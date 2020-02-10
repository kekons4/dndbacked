package com.dd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TableCreate {
	private String tableName = "";
    private String SQL_CREATE = "CREATE TABLE " + tableName
            + "("
            + " ID int NOT NULL,"
            + " username varchar(16),"
            + " password varchar(16),"
            + " PRIMARY KEY (ID)"
            + ")";
    
    //Create a new 
    public String createTable(String name) {
    	this.tableName = name;
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mariadb://192.168.1.134:3306/dd", "pi", "kls619a21b2");
             PreparedStatement preparedStatement = conn.prepareStatement("CREATE TABLE " + tableName
                     + "("
                     + " ID int NOT NULL,"
                     + " username varchar(16),"
                     + " password varchar(16),"
                     + " PRIMARY KEY (ID)"
                     + ")")) {

            preparedStatement.execute();
            return "SQL Table " + tableName + " Created!";

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            return e.getMessage();
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }

    }

}
