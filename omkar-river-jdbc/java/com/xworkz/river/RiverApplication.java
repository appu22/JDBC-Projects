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

//			String st = "INSERT INTO revier VALUES(1,'GANGA',805.0,0,'KODAGU')";
//			String st = "INSERT INTO river values(2,'Ganga',1,5,2525,'Gongotri')";
//			String st = "INSERT INTO river values(3,'Kaveri',3,8,1620,'TalaKAveri')";
//			String st = "INSERT INTO river values(4,'Krishna',0,10,1400,'Mahabaleshwar,')";
			String st = "INSERT INTO river values(1,'Ghataprbha',4,2,283,'Western Ghats')";
			
			int executeUpdate = statement.executeUpdate(st);
			
			System.out.println("records : "+executeUpdate+" Added Successfull....");
			connect.close();
		} else {

			System.out.println(" not connected--");
		}

	}

}
