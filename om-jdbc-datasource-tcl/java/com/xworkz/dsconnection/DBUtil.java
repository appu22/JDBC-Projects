package com.xworkz.dsconnection;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.mysql.cj.jdbc.MysqlDataSource;

public class DBUtil {
	// by default static and final
//	jdbc:mysql://localhost:3306/xworkz.db?useSSL=false"
	private static final String URL = "jdbc:mysql://localhost:3306/xworkz.db";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

	private static Properties properties = null;

	private static MysqlDataSource dataSource;

	static {

		properties = new Properties();
		try {
			properties.load(new FileInputStream("src/database.properties"));
		dataSource = new MysqlDataSource();
		dataSource.setUrl(URL);
		dataSource.setUser(USERNAME);
		dataSource.setPassword(PASSWORD);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
