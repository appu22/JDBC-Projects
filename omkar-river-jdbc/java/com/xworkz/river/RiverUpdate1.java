package com.xworkz.river;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class RiverUpdate1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String URL = "jdbc:mysql://localhost:3306/xworkz.db";
		String USERNAME = "root";
		String PASSWORD = "root";
		String DRIVER = "com.mysql.cj.jdbc.Driver";
//		String update = " update river set R_ORIGIN='Ghats Western ' where R_NAME='Ghataprbha'";

		Class.forName(DRIVER);
		Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		if(connection!=null) {
		Statement statement = connection.createStatement();
		String update = "update river set R_POLLUTED=2 where R_ID=3";
		int updated = statement.executeUpdate(update);
		System.out.println("updated Successfully.........!"+updated);
		connection.close();
		}else {
			System.out.println("Connection failed ...........!");
		}

	}

}
