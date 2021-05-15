package com.xworkz.tallestbuilding.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.activation.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import com.xworkz.tallestbuilding.DBConstants.DBConstants;
import com.xworkz.tallestbuilding.dto.TallestBuildingDTO;

public class TallestBuildingDAOImple implements TallestBuildingDAO {

	@Override
	public void save(TallestBuildingDTO dto) throws SQLException {

//		@SuppressWarnings("resource")
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setUrl(DBConstants.URL);
		basicDataSource.setUsername(DBConstants.USERNAME);
		basicDataSource.setPassword(DBConstants.PASSWORD);
		Connection conn = null;
		try (Connection connection = basicDataSource.getConnection()) {
			conn = connection;
			connection.setAutoCommit(false);
			String sql = "INSERT INTO  tallestbuilding VALUES (?,?,?,?,?,?,?)";
			PreparedStatement prepareStatement = connection.prepareStatement(sql);

			prepareStatement.setInt(1, dto.getId());

			prepareStatement.setString(2, dto.getName());
			prepareStatement.setDouble(3, dto.getLength());
			prepareStatement.setString(4, dto.getCountry());
			prepareStatement.setString(5, dto.getConstructedDate());
			prepareStatement.setString(6, dto.getConstructedBy());
			prepareStatement.setString(7, dto.getArea());

			boolean execute = prepareStatement.execute();
			System.out.println("Values are insterd : " + execute);
			connection.commit();
		} catch (SQLException exception) {
			exception.printStackTrace();
			conn.rollback();
		}
	}

	@Override
	public void save(List<TallestBuildingDTO> list) throws SQLException {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl(DBConstants.URL);
		dataSource.setUsername(DBConstants.USERNAME);
		dataSource.setPassword(DBConstants.PASSWORD);
		Connection conn = null;
		try (Connection connection = dataSource.getConnection()) {
			conn = connection;
			connection.setAutoCommit(false);
			Iterator<TallestBuildingDTO> iterator2 = list.iterator();
			while (iterator2.hasNext()) {
				TallestBuildingDTO dto = iterator2.next();
				String sql = "INSERT INTO  tallestbuilding VALUES (?,?,?,?,?,?,?)";
				PreparedStatement prepareStatement = connection.prepareStatement(sql);
				prepareStatement.setInt(1, dto.getId());
				prepareStatement.setString(2, dto.getName());
				prepareStatement.setDouble(3, dto.getLength());
				prepareStatement.setString(4, dto.getCountry());
				prepareStatement.setString(5, dto.getConstructedDate());
				prepareStatement.setString(6, dto.getConstructedBy());
				prepareStatement.setString(7, dto.getArea());
				boolean execute = prepareStatement.execute();
				System.out.println(execute);
			}
			conn.commit();
		} catch (SQLException exception) {
			exception.printStackTrace();
			conn.rollback();
		}
	}

	@Override
	public void updateLengthByName(double length, String name) throws SQLException {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl(DBConstants.URL);
		dataSource.setUsername(DBConstants.USERNAME);
		dataSource.setPassword(DBConstants.PASSWORD);
		System.out.println(dataSource);
		try (Connection connection = dataSource.getConnection()) {
			connection.setAutoCommit(false);
			System.out.println("Connection---" + connection);
//			update news.tallestbuilding set T_LENGTH=2000  where T_NAME='One World Trade Center';
			String select = "UPDATE tallestbuilding SET T_LENGTH=? WHERE T_NAME=?";
			PreparedStatement prepareStatement = connection.prepareStatement(select);
			prepareStatement.setDouble(1, length);
			prepareStatement.setString(2, name);
			System.out.println("hiiii" + prepareStatement);
			boolean execute = prepareStatement.execute();
			System.out.println("Executed..........");
			if (execute)
				System.out.println("values are updated...!");
//			connection.rollback();
			connection.commit();

		} catch (SQLException exception) {
			exception.printStackTrace();

		}
	}

	@Override
	public TallestBuildingDTO fetchByName(String name) throws SQLException {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl(DBConstants.URL);
		dataSource.setUsername(DBConstants.USERNAME);
		dataSource.setPassword(DBConstants.PASSWORD);
		Connection conn = null;
		try (Connection connection = dataSource.getConnection()) {
//			conn = connection;
			connection.setAutoCommit(false);
			String select = "SELECT * FROM tallestbuilding where T_NAME=?";
			PreparedStatement prepareStatement = connection.prepareStatement(select);
			prepareStatement.setString(1, name);
			boolean execute = prepareStatement.execute();
			if (execute) {
				ResultSet resultSet = prepareStatement.getResultSet();
				resultSet.next();

				int id = resultSet.getInt("T_ID");
				String name1 = resultSet.getString("T_NAME");
				System.out.println(name);
				double length = resultSet.getDouble("T_LENGTH");
				String country = resultSet.getString("T_COOUNTRY");
				String date = resultSet.getString("T_CONSTRUCTEDATE");
				String owner = resultSet.getString("T_CONSTRUCTEDATEBY");
				String area = resultSet.getString("T_AREA");

				TallestBuildingDTO buildingDTO = new TallestBuildingDTO(id, name1, length, country, date, owner, area);
				return buildingDTO;
			}
			conn.commit();
		}
		return null;
	}

	@Override
	public List<String> fetchTopFiveNames() throws SQLException {

		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl(DBConstants.URL);
		dataSource.setUsername(DBConstants.USERNAME);
		dataSource.setPassword(DBConstants.PASSWORD);
//		Connection conn = null;
		try (Connection connection = dataSource.getConnection()) {
//			conn = connection;
			connection.setAutoCommit(false);
			String select = "SELECT T_NAME FROM tallestbuilding limit 5";
//			select distinct salary from employee order by salary desc limit 5;
//			String select = "SELECT distinct T_NAME FROM news.tallestbuilding order by T_LENGTH desc limit 5 ; ";
			PreparedStatement prepareStatement = connection.prepareStatement(select);
			boolean execute = prepareStatement.execute();
			List<String> list = new LinkedList<String>();
			ResultSet resultSet = prepareStatement.getResultSet();
			int row = 0;
			if (execute) {
				while (resultSet.next()) {
					String name1 = resultSet.getString("T_NAME");
//					System.out.println(name1);	
					list.add(name1);
				}
				return list;
			} else {
				System.out.println("not found....");
			}
			connection.commit();
		}
		return null;
	}

	@Override
	public List<TallestBuildingDTO> fetchByLengthGreater(double length) throws SQLException {
		BasicDataSource datasoucre = new BasicDataSource();
		datasoucre.setUrl(DBConstants.URL);
		datasoucre.setUsername(DBConstants.USERNAME);
		datasoucre.setPassword(DBConstants.PASSWORD);
		try (Connection connection = datasoucre.getConnection()) {
			connection.setAutoCommit(false);
			String sql = "SELECT *  FROM tallestbuilding where T_LENGTH=? ";
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setDouble(1, length);
			boolean execute = prepareStatement.execute();
			System.out.println("values get ..");
			List<TallestBuildingDTO> list = new LinkedList<>();
			if (execute) {
				System.out.println(length);
				ResultSet resultSet = prepareStatement.getResultSet();
				resultSet.next();
				int id = resultSet.getInt("T_ID");
//				System.out.println(id);
				String name1 = resultSet.getString("T_NAME");
//				System.out.println(name1);
				double length2 = resultSet.getDouble("T_LENGTH");
				String country = resultSet.getString("T_COOUNTRY");
				String date = resultSet.getString("T_CONSTRUCTEDATE");
				String owner = resultSet.getString("T_CONSTRUCTEDATEBY");
				String area = resultSet.getString("T_AREA");

				TallestBuildingDTO buildingDTO = new TallestBuildingDTO(id, name1, length2, country, date, owner, area);
				list.add(buildingDTO);
				return list;

			} else {
				System.out.println("Not found ");
			}
			connection.commit();
		}

		return null;
	}

	@Override
	public List<Double> fetchByMaxTopFiveLength() throws SQLException {
		BasicDataSource datasource = new BasicDataSource();
		datasource.setUrl(DBConstants.URL);
		datasource.setUsername(DBConstants.USERNAME);
		datasource.setPassword(DBConstants.PASSWORD);
		Connection conne = null;
		try (Connection connection = datasource.getConnection()) {
			conne = connection;
			conne.getAutoCommit();
			String sql = "SELECT T_LENGTH FROM news.tallestbuilding order by T_LENGTH desc limit 5;";
//			"SELECT T_LENGTH FROM news.tallestbuilding order by T_LENGTH desc limit 5;"
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			boolean execute = prepareStatement.execute();
			List<Double> list = new LinkedList<Double>();
			ResultSet resultSet = prepareStatement.getResultSet();
			System.out.println("execute is " + execute);
			if (execute) {
				while (resultSet.next()) {
					double length2 = resultSet.getDouble("T_LENGTH");
//					System.out.println("Length : " + length2);
					list.add(length2);
				}
				return list;
			}
			conne.commit();
		}
		return null;
	}
}
