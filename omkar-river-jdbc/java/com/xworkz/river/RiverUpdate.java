package com.xworkz.river;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class RiverUpdate {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//FQCN
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url= "jdbc:mysql://localhost:3306/xworkz.db";
				//	jdbc:mysql://localhost:3306/xworkz.db
		String userName = "root";
		String password = "root";
		
		Connection connection = DriverManager.getConnection(url, userName, password);//abstarction
		if(connection != null ) {
		Statement statement = connection.createStatement();
//		String update = " update river set R_ORIGIN='Ghats Western ' where R_NAME='Ghataprbha'";
		
		
//		update R_LENGHT and R_DAM_NO based on R_NAME and R_ID
//		String update = "update river set R_LENGTH=2526,R_DAM_NO=6 where R_NAME='Ganga' and R_ID=2";

		//		update R_POLLUTED based on R_ID
//		String update = "update river set R_POLLUTED=5 where R_ID=3";
		
		
//		update R_ORIGIN,R_POLLUTTED,R_DAM_NO BASED ON R_NAME
		String update = "update river set R_ORIGIN='tala kaveri',R_POLLUTED=0,R_DAM_NO=10 where R_ID=3 ";
		
		int executeUpdate = statement.executeUpdate(update);
		System.out.println("executeUpdated "+executeUpdate);
		connection.close();
		
		}else {
			System.out.println("Not connected....");
		}
	}

}
