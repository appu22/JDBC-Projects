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
		dto.setRegisterName("B");
		dto.setGender(Gender.M);
		dto.setLookingFor("SDd");
		dto.setQualification("BE");
		dto.setHabbits("cricket");

		MatrimonyDAO dao = new MatrimonyDAOImple();
//		dao.save(dto);

//		MatrimonyDTO fetchByRegisterName = dao.fetchByRegisterName("teerthkumar");
//		System.out.println("Teerthkumar Details by using RegName :  " + fetchByRegisterName);

//		MatrimonyDTO fetchByID = dao.fetchByID(5);
//		System.out.println("Fetching all details bu using ID : "+fetchByID);
//
//		dao.updateHabbitsByRegName("Reading", "Rakesh");

//		MatrimonyDTO dto2 = dao.fetchByRegisterNameAndQualification("ABC", "sdsd");
//		System.out.println("Getting All details Of ABC using Name And Qualification : "+dto2);

//		MatrimonyDTO fetchByIdAndGender = dao.fetchByIdAndGender(2, Gender.O);
//		System.out.println("Displaying Using ID and Gender: "+fetchByIdAndGender);

//		int totalRow = dao.getTotalRow();
//		System.out.println("totalRow : " + totalRow);

//		
//		dao.deleteByRegNameAndGenderAndQualification("ADSSA", Gender.M, "BE");

//		MatrimonyDTO fecthGenderAndRegName = dao.fecthGenderAndRegName(Gender.F, "xyz");
//		System.out.println("Fecthing All details Using  Gender And RegName : " + fecthGenderAndRegName);

//		dao.updateQualifectionByRegNameAndDeleteByID("M Tech", "A", 7);

		MatrimonyDTO fetchByIDAndUpdateQualificationByRegName = dao.fetchByIDAndUpdateQualificationByRegName(1, "Bsc",
				"xyz");
		System.out.println(
				"Fetch By ID And Update Qualification By RegName :  " 
		+ fetchByIDAndUpdateQualificationByRegName);

	}

}
