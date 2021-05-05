package com.xworkz.customer.aggrigate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.xworkz.river.select.dbconstants.DBConstants;

public class BooksPriceSum {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName(DBConstants.DRIVER);
		Connection connection = null;
		try {

			connection = DriverManager.getConnection(DBConstants.URL, DBConstants.USERNAME, DBConstants.PASSWORD);
			Statement statement = connection.createStatement();
			String max = "select sum(B_PRICE) from books_details";
			ResultSet set = statement.executeQuery(max);

			set.next();
			double price = set.getDouble(1);
			System.out.println("Sum value of price : " + price);

		} finally {
			connection.close();
			System.out.println("Connection Closed.....!");
		}

	}

}