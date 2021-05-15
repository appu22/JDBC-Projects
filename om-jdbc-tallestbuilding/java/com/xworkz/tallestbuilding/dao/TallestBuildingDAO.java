package com.xworkz.tallestbuilding.dao;

import java.sql.SQLException;
import java.util.List;

import com.xworkz.tallestbuilding.dto.TallestBuildingDTO;

public interface TallestBuildingDAO {

	public void save(TallestBuildingDTO buildingDTO) throws SQLException;//done

	public void save(List<TallestBuildingDTO> list)throws SQLException;//done
	
	public void updateLengthByName(double length, String name)throws SQLException;

	public TallestBuildingDTO fetchByName(String name)throws SQLException;
	
	public List<String> fetchTopFiveNames()throws SQLException;//done
	
	public List<TallestBuildingDTO> fetchByLengthGreater(double length)throws SQLException;
	
	public List<Double> fetchByMaxTopFiveLength()throws SQLException;
	
}
