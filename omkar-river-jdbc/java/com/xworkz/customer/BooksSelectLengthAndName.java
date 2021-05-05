package com.xworkz.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.xworkz.river.select.dbconstants.DBConstants;

public class BooksSelectLengthAndName {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName(DBConstants.DRIVER);
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DBConstants.URL, DBConstants.USERNAME, DBConstants.PASSWORD);

			Statement statement = connection.createStatement();

			String select = "select B_NO_OF_PAGES,B_NAME from books_details where B_ID=1 ";

			ResultSet result = statement.executeQuery(select);

			boolean sql = result.next();
			System.out.println("Execute Query " + sql);

			int pages = result.getInt(1);
			System.out.println("number of pages  : " + pages);

			String name = result.getString(2);
			System.out.println("Book name : " + name);

		} finally {
			connection.close();
			System.out.println("Connection closed..........!");
		}

	}
}
