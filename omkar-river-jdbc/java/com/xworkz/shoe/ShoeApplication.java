package com.xworkz.shoe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ShoeApplication {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/xworkz.db", "root", "root");

		if (connect != null) {
			System.out.println("--Connection Established--");

			Statement statement = connect.createStatement();
			
			String st = "INSERT INTO shoe VALUES (3,'MAX','MAX ',500,8);";
			
			int executeUpdate = statement.executeUpdate(st);
			
				System.out.println("recordes : "+executeUpdate+ " Added successfull");
		} else {
			System.out.println("--Not Connected---");
		}

	}

}
