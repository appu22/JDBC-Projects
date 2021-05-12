package com.xworkz.matrimony.DAO;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
import com.xworkz.constants.DBConstants;
import com.xworkz.matrimony.DTO.MatrimonyDTO;
import com.xworkz.matrimony.DTO.MatrimonyDTO.Gender;

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

			if (!execute)
				System.out.println("inserted ..." + execute);
		} finally {
			connection.close();
			System.out.println("Connection close............");
		}

	}

	@Override
	public MatrimonyDTO fetchByRegisterName(String name) throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DBConstants.URL, DBConstants.USERNAME, DBConstants.PASSWORD);
			String sql = "select * from matrimony where M_REG_NAME=?";
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, name);
			boolean resultset = prepareStatement.execute();
			if (resultset) {
				System.out.println("Resultset Found ...");
				ResultSet rs = prepareStatement.getResultSet();
				rs.next();
				int id = rs.getInt(1);
				String regName = rs.getString(2);
				String gender = rs.getString(3);
				String lookingFor = rs.getString(4);
				String qualification = rs.getString(5);
				String habbits = rs.getString(6);

				MatrimonyDTO dto = new MatrimonyDTO();
				dto.setMid(id);
				dto.setRegisterName(regName);
				// Convert String to enum jdbc will not return enum
				if (gender.equals("F"))
					dto.setGender(Gender.F);
				if (gender.equals("M"))
					dto.setGender(Gender.M);
				if (gender.equals("O"))
					dto.setGender(Gender.O);
				dto.setLookingFor(lookingFor);
				dto.setQualification(qualification);
				dto.setHabbits(habbits);
				return dto;
			}

		} finally {
			connection.close();
			System.out.println("Connection close....!");
		}
		return null;
	}

	@Override
	public MatrimonyDTO fetchByID(int id) throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DBConstants.URL, DBConstants.USERNAME, DBConstants.PASSWORD);
			String sql = "select * from matrimony where M_ID=? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			boolean execute = preparedStatement.execute();
			if (execute) {
				System.out.println("Result Found.......!");
				ResultSet resultSet = preparedStatement.getResultSet();
				while (resultSet.next()) {

					int id1 = resultSet.getInt(1);
					String regName = resultSet.getString(2);
					String gender = resultSet.getString(3);
					String lookingFor = resultSet.getString(4);
					String qualification = resultSet.getString(5);
					String habbits = resultSet.getString(6);

					MatrimonyDTO dto = new MatrimonyDTO();
					dto.setMid(id1);
					dto.setRegisterName(regName);
					if (gender.equals("F"))
						dto.setGender(Gender.F);
					if (gender.equals("M"))
						dto.setGender(Gender.M);
					if (gender.equals("O"))
						dto.setGender(Gender.O);
					dto.setLookingFor(lookingFor);
					dto.setQualification(qualification);
					dto.setHabbits(habbits);

					return dto;

				}
			}
		} finally {
			connection.close();
			System.out.println("Connection Closed...");
		}

		return null;
	}

	@Override
	public void updateHabbitsByRegName(String habbit, String name) throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DBConstants.URL, DBConstants.USERNAME, DBConstants.PASSWORD);
			String update = "update matrimony set M_HABITS=?  WHERE M_REG_NAME=?";
//			update `xworkz.db`.matrimony set M_HABITS='Reading' where M_REG_NAME='Rakesh';
			PreparedStatement preparedStatement = connection.prepareStatement(update);
			preparedStatement.setString(1, habbit);
			preparedStatement.setString(2, name);
			boolean execute = preparedStatement.execute();
			System.out.println("updated..");
			System.out.println("Updated Habbits : " + habbit);
			System.out.println("Reg Name : " + name);
		} finally {
			connection.close();
			System.out.println("Connection Closed...");

		}

	}

	@Override
	public MatrimonyDTO fetchByRegisterNameAndQualification(String name, String qal) throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DBConstants.URL, DBConstants.USERNAME, DBConstants.PASSWORD);
//			String update = "select M_REG_NAME=?,M_QUALIFICATION=? from  matrimony;";
//			String sql = "select * from matrimony where M_REG_NAME=?";
//			select M_REG_NAME='Kiran', M_QUALIFICATION='Msc CS'  from `xworkz.db`.matrimony;

			String update = "select * from  matrimony where M_REG_NAME=? and M_QUALIFICATION=? ;";
			PreparedStatement preparedStatement = connection.prepareStatement(update);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, qal);
			boolean execute = preparedStatement.execute();
			if (execute) {
				System.out.println("updated..");
				ResultSet resultSet = preparedStatement.getResultSet();
				while (resultSet.next()) {
					int id1 = resultSet.getInt(1);
					String regName = resultSet.getString(2);
//					System.out.println(regName);
					String gender = resultSet.getString(3);
					String lookingFor = resultSet.getString(4);
					String qualification = resultSet.getString(5);
					String habbits = resultSet.getString(6);

					MatrimonyDTO dto = new MatrimonyDTO();
					dto.setMid(id1);
					dto.setRegisterName(regName);

					if (gender.equals("F"))
						dto.setGender(Gender.F);
					if (gender.equals("M"))
						dto.setGender(Gender.M);
					if (gender.equals("O"))
						dto.setGender(Gender.O);
					dto.setLookingFor(lookingFor);
					dto.setQualification(qualification);
					dto.setHabbits(habbits);
					return dto;

				}
			} else {
				System.out.println("not found...");
			}
		} finally {
			connection.close();
			System.out.println("Connection Closed...");

		}
		return null;
	}

	@Override
	public MatrimonyDTO fetchByIdAndGender(int id, Gender gender) throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DBConstants.URL, DBConstants.USERNAME, DBConstants.PASSWORD);
//			String update = "select M_ID=?,M_GENDER=? from  matrimony;";
			String update = "select * from  matrimony where M_ID=? and M_GENDER=?;";
//			String update = "select * from  matrimony where M_REG_NAME=? and M_QUALIFICATION=? ;";
			PreparedStatement preparedStatement = connection.prepareStatement(update);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, gender.toString());
			boolean execute = preparedStatement.execute();
			if (execute) {
				System.out.println("Fetch...............");
				ResultSet resultSet = preparedStatement.getResultSet();
				resultSet.next();
				int id1 = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String gende = resultSet.getString(3);
				String lookingFor = resultSet.getString(4);
				String qualification = resultSet.getString(5);
				String habits = resultSet.getString(6);
				MatrimonyDTO dto = new MatrimonyDTO();
				dto.setMid(id1);
				dto.setRegisterName(name);
				if (gende.equals("F"))
					dto.setGender(Gender.F);
				if (gende.equals("M"))
					dto.setGender(Gender.M);
				if (gende.equals("O"))
					dto.setGender(Gender.O);
				dto.setLookingFor(lookingFor);
				dto.setQualification(qualification);
				dto.setHabbits(habits);

				return dto;

			} else {
				System.out.println("not Found....");
			}

		} finally {
			connection.close();
			System.out.println("Connection  Closed");

		}
		return null;
	}

	@Override
	public void deleteByRegNameAndGenderAndQualification(String name, Gender gender, String qua) throws SQLException {
		Connection connection = null;
		try {

			connection = DriverManager.getConnection(DBConstants.URL, DBConstants.USERNAME, DBConstants.PASSWORD);
			String update = "delete from matrimony where M_REG_NAME=? and M_GENDER=? and M_QUALIFICATION=? ;";
//			delete from `xworkz.db`.matrimony where M_REG_NAME='' and M_GENDER='' and M_QUALIFICATION='' ;
//			String update = "select * from  matrimony where M_ID=? and M_GENDER=?;";
			PreparedStatement preparedStatement = connection.prepareStatement(update);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, gender.toString());
			preparedStatement.setString(3, qua);
			boolean execute = preparedStatement.execute();
			if (!execute) {
				System.out.println("deleted..............." + execute);

			} else {
				System.out.println("not Found....");
			}

		} finally {
			connection.close();
			System.out.println("Connection  Closed");

		}
	}

	@Override
	public int getTotalRow() throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DBConstants.URL, DBConstants.USERNAME, DBConstants.PASSWORD);
			String sql = "select count(M_ID) from matrimony ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			boolean execute = preparedStatement.execute();
			if (execute) {
				System.out.println("Result found");
				ResultSet resultSet = preparedStatement.getResultSet();
				resultSet.next();
				int totalrows = resultSet.getInt(1);
				return totalrows;
			} else {
				System.out.println("Not found...");
			}
		} finally {
			connection.close();
			System.out.println("Connection Closed............");

		}
		return 0;
	}

	@Override
	public MatrimonyDTO fecthGenderAndRegName(Gender gender, String regName) throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DBConstants.URL, DBConstants.USERNAME, DBConstants.PASSWORD);
			String select = "select * from matrimony where M_GENDER=? and M_REG_NAME=? ";
			PreparedStatement prepareStatement = connection.prepareStatement(select);
			prepareStatement.setString(1, gender.toString());
			prepareStatement.setString(2, regName);
			boolean execute = prepareStatement.execute();
			if (execute) {
				System.out.println("Fetch...............");
				ResultSet resultSet = prepareStatement.getResultSet();
				resultSet.next();
				int id1 = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String gende = resultSet.getString(3);
				String lookingFor = resultSet.getString(4);
				String qualification = resultSet.getString(5);
				String habits = resultSet.getString(6);
				MatrimonyDTO dto = new MatrimonyDTO();
				dto.setMid(id1);
				dto.setRegisterName(name);
				if (gende.equals("F"))
					dto.setGender(Gender.F);
				if (gende.equals("M"))
					dto.setGender(Gender.M);
				if (gende.equals("O"))
					dto.setGender(Gender.O);
				dto.setLookingFor(lookingFor);
				dto.setQualification(qualification);
				dto.setHabbits(habits);

				return dto;

			} else {
				System.out.println("not Found....");
			}
		} finally {
			connection.close();
			System.out.println("Connection closed.......");
		}
		return null;
	}

	@Override
	public void updateQualifectionByRegNameAndDeleteByID(String qua, String regName, int deleteID) throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DBConstants.URL, DBConstants.USERNAME, DBConstants.PASSWORD);
			String update = "update matrimony set M_QUALIFICATION=?  where M_REG_NAME= ? ";
			PreparedStatement prepareStatement = connection.prepareStatement(update);
			prepareStatement.setString(1, qua);
			prepareStatement.setString(2, regName);
			boolean execute = prepareStatement.execute();

			String delete = "delete from matrimony where M_ID=? ";
			PreparedStatement prepareStatement2 = connection.prepareStatement(delete);
			prepareStatement2.setInt(1, deleteID);
			boolean execute2 = prepareStatement2.execute();
			System.out.println("Deleted successfull.... " + execute2);
			if (!execute) {

				System.out.println("updated successfull...............");
			}
		} finally {
			connection.close();
			System.out.println("connection closed.......");
		}

	}

	@Override
	public MatrimonyDTO fetchByIDAndUpdateQualificationByRegName(int id, String qua, String regName)
			throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DBConstants.URL, DBConstants.USERNAME, DBConstants.PASSWORD);

			String fecth = "select * from matrimony where M_ID=? ";
			PreparedStatement prepareStatement = connection.prepareStatement(fecth);
			prepareStatement.setInt(1, id);
			boolean execute = prepareStatement.execute();
			String update = "update matrimony set M_QUALIFICATION=? where M_REG_NAME=?";
//			String update = "update matrimony set M_HABITS=?  WHERE M_REG_NAME=?";
			PreparedStatement prepareStatement2 = connection.prepareStatement(update);
			prepareStatement2.setString(1, qua);
			prepareStatement2.setString(2, regName);
			boolean execute2 = prepareStatement2.execute();
			System.out.println("Qualification Updated.."+qua);
			if (execute) {
				System.out.println("Result found...");
				ResultSet resultSet = prepareStatement.getResultSet();
				resultSet.next();
				int id1 = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String gender = resultSet.getString(3).toString();
				String lookingFor = resultSet.getString(4);
				String qualification = resultSet.getNString(5);
				String habits = resultSet.getString(6);

				MatrimonyDTO dto = new MatrimonyDTO();
				dto.setMid(id1);
				dto.setRegisterName(name);
				dto.setLookingFor(lookingFor);
				dto.setQualification(qualification);
				dto.setHabbits(habits);
				if (gender.equals("F"))
					dto.setGender(Gender.F);
				if (gender.equals("M"))
					dto.setGender(Gender.M);
				if (gender.equals("O"))
					dto.setGender(Gender.O);
				return dto;
			} else {
				System.out.println("given input wrong ..");
			}
		} finally {
			connection.close();
			System.out.println("connection closed....");
		}
		return null;
	}

}
