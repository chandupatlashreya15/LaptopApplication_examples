package com.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/school";
		String uname ="root";
		String pass="root";
		Connection conn = DriverManager.getConnection(url,uname,pass);
		return conn;
	}

}
