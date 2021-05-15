package com.xworkz.tallestbuilding;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xworkz.tallestbuilding.dao.TallestBuildingDAO;
import com.xworkz.tallestbuilding.dao.TallestBuildingDAOImple;
import com.xworkz.tallestbuilding.dto.TallestBuildingDTO;

public class TallestBuildingTester {

	public static void main(String[] args) throws SQLException {
//			 World View	911	Mumbai	2020-02-05	India	Tishman 
//		'5', '	One World Trade Center', '1965', 'New York City', '2014-02-05', 'United States', 'Tishman '

		TallestBuildingDTO buildingDTO = new TallestBuildingDTO(5, "One World Trade Center", 1965.0, "New York City",
				"2024-02-05", "United Sates", "qwerty");

		TallestBuildingDTO dto1 = new TallestBuildingDTO(11, "One World Trade Center", 1965.0, "New York City",
				"2024-02-05", "United Sates", "qwerty");
		TallestBuildingDTO dto2 = new TallestBuildingDTO(21, "One World Trade Center", 1965.0, "New York City",
				"2024-02-05", "United Sates", "qwerty");

		List<TallestBuildingDTO> list = new ArrayList<TallestBuildingDTO>();
		list.add(dto1);
		list.add(dto2);

		TallestBuildingDAO daoimple = new TallestBuildingDAOImple();

//		*******************************************************************************************
//		daoimple.save(buildingDTO);

//		*******************************************************************************************
//		daoimple.save(list);

//		*******************************************************************************************
//		daoimple.updateLengthByName(1500, "One World Trade Center");

//		*******************************************************************************************
//		TallestBuildingDTO fetchByName = daoimple.fetchByName("Shanghai Tower");
//		System.out.println(fetchByName);

//		*******************************************************************************************
//		List<String> fetchTopFiveNames = daoimple.fetchTopFiveNames();
//		if (fetchTopFiveNames != null) {
//			System.out.println("Total rows  - " + fetchTopFiveNames.size());
//			fetchTopFiveNames.forEach(e -> System.out.println(e));
//		}
//		
//		*******************************************************************************************
//		List<Double> fetchByMaxTopFiveLength = daoimple.fetchByMaxTopFiveLength();
//		System.out.println("Highest top five length : ");
//		if (fetchByMaxTopFiveLength != null) {
//			fetchByMaxTopFiveLength.forEach(e -> System.out.println(e));
//		}
	}
}
