package com.xworkz.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.xworkz.river.select.dbconstants.DBConstants;

public class BooksSelectLength {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName(DBConstants.DRIVER);
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DBConstants.URL, DBConstants.USERNAME, DBConstants.PASSWORD);

			Statement statement = connection.createStatement();
			double price = 400;
			double price1 = 1000;
//						"SELECT * FROM river where R_LENGTH > "+length+" and R_LENGTH < "+length1
			String select = "select * from books_details where B_PRICE > " + price + "and  B_PRICE <" + price1;

			ResultSet resultSet = statement.executeQuery(select);
			boolean next = resultSet.next();
			System.out.println("The given condtion is : " + resultSet);
			while (resultSet.next()) { // row

				int bid = resultSet.getInt(1);
				System.out.println("Book ID   : " + bid);

				double bookprice = resultSet.getDouble(2);
				System.out.println("Book Price : " + bookprice);

				String bookname = resultSet.getString(3);
				System.out.println("Book Name : " + bookname);

				int pages = resultSet.getInt(4);
				System.out.println("Number of pages  : " + pages);

				String author = resultSet.getString(5);
				System.out.println("Book Author" + author);
				System.out.println("--------------------------------------------------");
			}
		} finally {
			connection.close();
			System.out.println("Connetion closed.....!");
		}
	}

}
