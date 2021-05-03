package com.xworkz.river;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RiverDelete {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/xworkz.db";
		String un="root";
		String pwd="root";

		Connection connection = DriverManager.getConnection(url,un,pwd);//abstarction without knowing implentation
		if(connection != null) {
			String delete="delete from river where R_ID=2";
			PreparedStatement prepareStatement = connection.prepareStatement(delete);
			
			System.out.println("Deleted Successfull...."+prepareStatement);
//			connection.close();
		}else {
			System.out.println("Connection not connnected ....");
		}
		
	}
	
	

}
