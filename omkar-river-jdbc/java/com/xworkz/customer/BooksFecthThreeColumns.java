package com.xworkz.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.xworkz.river.select.dbconstants.DBConstants;

public class BooksFecthThreeColumns {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName(DBConstants.DRIVER);
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DBConstants.URL, DBConstants.USERNAME, DBConstants.PASSWORD);

			Statement statement = connection.createStatement();
			String select = "select B_NAME,B_PRICE,B_AUTHOR from books_details";

			ResultSet result = statement.executeQuery(select);
			System.out.println("Books Details -- B_NAME,B_PRICE,B_AUTHOR  -- ");
			while (result.next()) {
				String name = result.getString(1);
				System.out.println("Book name   : " + name);

				double price = result.getDouble(2);
				System.out.println("Book price  : " + price);

				String author = result.getString(3);
				System.out.println("Author Name : " + author);
				System.out.println("----------------------------------------");

			}

		} finally {
			connection.close();
			System.out.println("Connection closed............!");
		}

	}

}
