package com.xworkz.river;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class RiverUpdate2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String URl = "jdbc:mysql://localhost:3306/xworkz.db";
		String USERNAME = "root";
		String PASSWORD = "root";
		String DRIVER = "com.mysql.cj.jdbc.Driver";

		Class.forName(DRIVER);
		Connection connection = DriverManager.getConnection(URl, USERNAME, PASSWORD);
		if (connection != null) {
			Statement statement = connection.createStatement();
			String update = "update river set R_DAM_NO=5 where R_ID=4;";
			// update R_POLLUTED based on R_ID
//			String update = "update river set R_POLLUTED=5 where R_ID=3";
			int values = statement.executeUpdate(update);
			System.out.println("records updated....." + values);
//			connection.close();
		} else {
			System.out.println("Connection failed...!");
		}
	}
}
