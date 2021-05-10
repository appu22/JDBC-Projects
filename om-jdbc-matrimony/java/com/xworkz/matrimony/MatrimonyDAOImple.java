package com.xworkz.matrimony;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.xworkz.constants.DBConstants;

public class MatrimonyDAOImple implements MatrimonyDAO {

	public MatrimonyDAOImple() {
		System.out.println(getClass().getSimpleName() + " ");
	}

	@Override
	public void save(MatrimonyDTO dto) throws SQLException {

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DBConstants.URL, DBConstants.USERNAME, DBConstants.PASSWORD);

//		Statement createStatement = connection.createStatement();
			String sql = "INSERT INTO matrimony VALUES(?,?,?,?,?,?)";
			PreparedStatement prepareStatement = connection.prepareStatement(sql);

			prepareStatement.setInt(1, dto.getMid());
			prepareStatement.setString(2, dto.getRegisterName());
			prepareStatement.setObject(3, dto.getGender().toString());
			prepareStatement.setString(4, dto.getLookingFor());
			prepareStatement.setString(5, dto.getQualification());
			prepareStatement.setString(6, dto.getHabbits());

			boolean execute = prepareStatement.execute();
			if(!execute) 
			System.out.println("inserted ..." + execute);
			
		} finally {
			connection.close();
			System.out.println("Connection close............");
		}

	}

}
