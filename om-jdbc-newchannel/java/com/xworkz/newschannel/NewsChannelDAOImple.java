package com.xworkz.newschannel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class NewsChannelDAOImple implements NewsChannelDAO {

	@Override
	public void save(NewsChannelDTO dto) throws ClassNotFoundException, SQLException {

		Class.forName(DBConstants.DRIVER);
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DBConstants.URL, DBConstants.USERNAME, DBConstants.PASSWORD);

			Statement statement = connection.createStatement();

//			String sql = "insert into news_channel values(1)";
			String sql = "insert into news_channel values (" + dto.getId() + ",'" + dto.getName() + "','"
					+ dto.getOwner() + "','" + dto.getEditor() + "','" + dto.getLang() + "')";

			statement.executeUpdate(sql);
			System.out.println(sql);

		} finally {
			connection.close();
			System.out.println("Connection closed........!");
		}
	}

	@Override
	public void updateByEditorByName(String editorname, String name1) throws ClassNotFoundException, SQLException {
		Class.forName(DBConstants.DRIVER);
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DBConstants.URL, DBConstants.USERNAME, DBConstants.PASSWORD);
			Statement statement = connection.createStatement();
			String update = "update news_channel set n_editor='"+editorname+"'where n_name='"+name1+"'";

//			update customer_details set COUSTOMER_ORDER_VALUE =500.0 where CUSTOMER_ID=4;
			statement.executeUpdate(update);
			System.out.println(update);
		} finally {
			connection.close();
			System.out.println("Connection Closed.....!");
		}

	}

	@Override
	public void deleteByName(String name) throws ClassNotFoundException, SQLException 
	{
	Class.forName(DBConstants.DRIVER);
	Connection connection = null;
	try {
		connection = DriverManager.getConnection(DBConstants.URL, DBConstants.USERNAME, DBConstants.PASSWORD);
		Statement statement = connection.createStatement();
		String delete = "delete from news_channel where  n_name ='"+name+"' ";
		statement.executeUpdate(delete);
		System.out.println("Deleted Succssfully....!"+delete);
	} finally {
		connection.close();
		System.out.println("Connection Closed.....!");
	}

}

}
