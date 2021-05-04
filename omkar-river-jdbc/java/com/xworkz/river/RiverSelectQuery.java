package com.xworkz.river;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RiverSelectQuery {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String URL = "jdbc:mysql://localhost:3306/xworkz.db";
		String USERNAME = "root";
		String PASSWORD = "root";
		String DRIVER = "com.mysql.cj.jdbc.Driver";
		Class.forName(DRIVER);
		Connection connction = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		Statement statement = connction.createStatement();
		String select = "select R_ORIGIN from river where R_NAME='Ghataprbha' and R_ORIGIN='Ghats Western '";

		ResultSet resultset = statement.executeQuery(select);

		boolean next = resultset.next();
		System.out.println("The Goven condtion is --> " + next);

		String origin = resultset.getString(1);
		System.out.println("River Origin------------> " + origin);

	}

}
