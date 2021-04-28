package com.xworkz.river;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class RiverApplication {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/xworkz.db", "root", "root");

		if (connect != null) {
			System.out.println("Connected to DB, Can follow next steps ");

			Statement statement = connect.createStatement();

			String st = "INSERT INTO revier VALUES(2,'GANGA',805.0,0,'KODAGU')";
			
			int executeUpdate = statement.executeUpdate(st);
			
			System.out.println("records : "+executeUpdate+" Added Successfull....");
		} else {

			System.out.println(" not connected--");
		}

	}

}
