package com.xworkz.river;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class RiverDelete {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/xworkz.db";
		String un="root";
		String pwd="root";
		Connection connection = DriverManager.getConnection(url,un,pwd); 
		
		//abstarction without knowing implentation 
		if(connection != null) {
			Statement  statement = connection.createStatement();
			String delete="delete from river where R_ID=2";
			int executeUpdate = statement.executeUpdate(delete);
			
			System.out.println("Deleted Successfull...."+executeUpdate);
			connection.close();
		}else {
			System.out.println("Connection not connnected ....");
		}
		
	}
	
	

}
