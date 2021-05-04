package com.xworkz.river.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RiverSelectGivenThreeCondtions {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		String URl = "jdbc:mysql://localhost:3306/xworkz.db";
		String USERNAME = "root";
		String PASSWORD = "root";
		String DRIVER = "com.mysql.cj.jdbc.Driver";

		Class.forName(DRIVER);
		Connection connection = DriverManager.getConnection(URl, USERNAME, PASSWORD);
		if (connection != null) {

			Statement statement = connection.createStatement();

			String select = "select R_ID,R_LENGTH,R_POLLUTED FROM RIVER WHERE R_NAME='Krishna' and R_ORIGIN='Mahabaleshwar,'";

			System.out.println("********** River Details ************");
			ResultSet resultset = statement.executeQuery(select);

			boolean next = resultset.next();
			System.out.println("The Given Condition is : " + next);
			int id = resultset.getInt(1);
			System.out.println("River ID --------> " + id);

			int dam = resultset.getInt(2);
			System.out.println("River Dams ------> " + dam);

			int LENGTH = resultset.getInt(3);
			System.out.println("River Length ----> " + LENGTH);

		} else {
			System.out.println("Connection Failed.....!");
		}

	}

}