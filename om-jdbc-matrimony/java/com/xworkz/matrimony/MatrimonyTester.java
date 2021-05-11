package com.xworkz.matrimony;

import java.sql.SQLException;

import com.xworkz.matrimony.DAO.MatrimonyDAO;
import com.xworkz.matrimony.DAO.MatrimonyDAOImple;
import com.xworkz.matrimony.DTO.MatrimonyDTO;
import com.xworkz.matrimony.DTO.MatrimonyDTO.Gender;

public class MatrimonyTester {

	public static void main(String[] args) throws SQLException {

		MatrimonyDTO dto = new MatrimonyDTO();
		dto.setMid(7);
		dto.setRegisterName("teerthKumar");
		dto.setGender(Gender.M);
		dto.setLookingFor("girl");
		dto.setQualification("BE");
		dto.setHabbits("cricket");

		MatrimonyDAO dao = new MatrimonyDAOImple();
//		dao.save(dto);

//		MatrimonyDTO fetchByRegisterName = dao.fetchByRegisterName("teerthkumar");
//		System.out.println("Main method   " + fetchByRegisterName);

//		MatrimonyDTO fetchByID = dao.fetchByID(3);
//		System.out.println(fetchByID);

//		dao.updateHabbitsByRegName("Reading", "Rakesh");

//		MatrimonyDTO dto2 = dao.fetchByRegisterNameAndQualification("vishal", "BA");
//		System.out.println(dto2);

//		MatrimonyDTO fetchByIdAndGender = dao.fetchByIdAndGender(2, Gender.O);
//		System.out.println("Displaying Using ID and Gender: "+fetchByIdAndGender);

//		int totalRow = dao.getTotalRow();
//		System.out.println("totalRow : " + totalRow);

//		
//		dao.deleteByRegNameAndGenderAndQualification("vishal", Gender.F, "BA");

//		MatrimonyDTO fecthGenderAndRegName = dao.fecthGenderAndRegName(Gender.F, "xyz");
//		System.out.println("Fcth Gender And RegName : " + fecthGenderAndRegName);

		dao.updateQualifectionByRegNameAndDeleteByID("sdsd", "ABC", 6);

//		MatrimonyDTO fetchByIDAndUpdateQualificationByRegName = 
//				dao.fetchByIDAndUpdateQualificationByRegName(6, "Agri","ABC");
//
//		System.out.println("fetchByIDAndUpdateQualificationByRegName : "
//				+ "" + fetchByIDAndUpdateQualificationByRegName);

	}

}
