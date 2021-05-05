package com.xworkz.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.xworkz.river.select.dbconstants.DBConstants;

public class BooksUsingWhileLoop {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName(DBConstants.DRIVER);

		Connection connection = DriverManager.getConnection(DBConstants.URL, DBConstants.USERNAME,
				DBConstants.PASSWORD);

		Statement statement = connection.createStatement();

		String select = "select * from books_details";

		ResultSet resultSet = statement.executeQuery(select);
		System.out.println("************ Books Details **********");
		while (resultSet.next()) {

			int bid = resultSet.getInt(1);
			System.out.println("Book ID   : " + bid);

			double price = resultSet.getDouble(2);
			System.out.println("Book Price : " + price);

			String bookname = resultSet.getString(3);
			System.out.println("Book Name : " + bookname);

			int pages = resultSet.getInt(4);
			System.out.println("Number of pages  : " + pages);

			String author = resultSet.getString(5);
			System.out.println("Book Author" + author);
			System.out.println("--------------------------------------------------");
		}

	}

}
