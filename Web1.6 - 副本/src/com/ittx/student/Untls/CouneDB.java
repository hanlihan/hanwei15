package com.ittx.student.Untls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.ittx.student.model.Student;

public class CouneDB {
	private static final String url = "jdbc:mysql://localhost:3306/teststu";
	private static final String user = "root";
	private static final String password = "154331";

	public  CouneDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		Connection connect = null;
		try {
			connect = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connect;
	}

	public void closeConnection(Connection connect) {
		try {
			if (connect != null)
				connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	
}
