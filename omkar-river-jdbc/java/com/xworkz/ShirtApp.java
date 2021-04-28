package com.xworkz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ShirtApp {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/xworkz.db", "root", "root");

		if (connect != null) {
			System.out.println("Connected --");

			Statement st = connect.createStatement();
			String s = "INSERT INTO shirt VALUES (2,'BLUE','350','S-SIZE')";

			st.executeUpdate(s);

		} else {
			System.out.println("not Connected ");
		}

	}
}
