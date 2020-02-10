package com.dd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class autoINV {

	private String tableName = "";
    /*private String SQL_CREATE = "CREATE TABLE " + tableName
            + "("
            + " ID int NOT NULL,"
            + " username varchar(16),"
            + " password varchar(16),"
            + " PRIMARY KEY (ID)"
            + ")";
	*/
    public String createINV(String name) {
    	this.tableName = name;
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mariadb://192.168.1.134:3306/dd", "pi", "kls619a21b2");
             PreparedStatement preparedStatement = conn.prepareStatement("CREATE TABLE " + tableName
                     + "("
                     + " item_id varchar(255) NOT NULL,"
                     + " item_name varchar(32),"
                     + " quantity int NOT NULL,"
                     + " PRIMARY KEY (item_id)"
                     + ")")) {

            preparedStatement.execute();
            return "Inventory Created!";

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            return e.getMessage();
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }

    }

}
