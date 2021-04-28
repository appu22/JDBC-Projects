package com.xworkz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ChiarAppliction {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// class not found exception checked/compile exception
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection connection = 
			DriverManager.getConnection("jdbc:mysql://localhost:3306/xworkz.db","root","root");

		if (connection != null) {
			System.out.println("Connected..!");
			Statement statement = connection.createStatement();
			
			String a ="INSERT INTO chair VALUES(1,'PLASTIC CHIAR',900)";
		int i = statement.executeUpdate(a);
		System.out.println(i);

		} else {
			System.out.println("not Connected..!");

		}
	}

}
