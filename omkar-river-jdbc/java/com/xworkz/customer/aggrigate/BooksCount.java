package com.xworkz.customer.aggrigate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.xworkz.river.select.dbconstants.DBConstants;

public class BooksCount {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName(DBConstants.DRIVER);
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DBConstants.URL, DBConstants.USERNAME, DBConstants.PASSWORD);

			Statement statement = connection.createStatement();

//			String count = "select max(B_NO_OF_PAGES) from books_details";
			String count = "select count(*) from books_details";
			ResultSet result = statement.executeQuery(count);

			result.next();
			int rows = result.getInt(1);
			System.out.println("Total number of  rows " + rows);

		} finally {
			connection.close();
			System.out.println("Connection closed .....!");
		}

	}

}
