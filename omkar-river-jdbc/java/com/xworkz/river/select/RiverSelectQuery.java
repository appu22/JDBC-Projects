package com.xworkz.river.select;

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
		Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); // interface

		Statement statement = connection.createStatement(); // interface
		// abstraction --> connection,statement,ResultSet
		String select = "select * from river where R_NAME='Kaveri'";
		ResultSet row = statement.executeQuery(select); // interface
		row.next(); // cursor pointing to the next column
		int id = row.getInt(1);// starts with 1
		System.out.println("Show Row details --> " + id);

		String riverName = row.getString(2);
		System.out.println("River Name---------> " + riverName);

		int polluted = row.getInt(3);
		System.out.println("River Polluted-----> " + polluted);

		int dam = row.getInt(4);
		System.out.println("River Dams --------> " + dam);

		int length = row.getInt(5);
		System.out.println("River Length ------> " + length);

		String origin = row.getString(6);
		System.out.println("River Origin ------> " + origin);

		connection.close();
		System.out.println("closed............");

	}
}
