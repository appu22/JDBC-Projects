package com.xworkz.matrimony;

import java.sql.SQLException;

import com.xworkz.matrimony.MatrimonyDTO.Gender;

public class MatrimonyTester {

	public static void main(String[] args) throws SQLException {

		MatrimonyDTO dto = new MatrimonyDTO();
		dto.setMid(1);
		dto.setRegisterName("Kiran");
		dto.setGender(Gender.M);
		dto.setLookingFor("Silent Boy");
		dto.setQualification("Msc CS");
		dto.setHabbits("Watching Video");

		MatrimonyDAO dao = new MatrimonyDAOImple();
		dao.save(dto);

	}

}
