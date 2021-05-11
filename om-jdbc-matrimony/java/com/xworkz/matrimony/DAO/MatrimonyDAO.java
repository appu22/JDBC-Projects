package com.xworkz.matrimony.DAO;

import java.sql.SQLException;

import com.xworkz.matrimony.DTO.MatrimonyDTO;
import com.xworkz.matrimony.DTO.MatrimonyDTO.Gender;

public interface MatrimonyDAO {

	public void save(MatrimonyDTO dto) throws SQLException;

	public MatrimonyDTO fetchByRegisterName(String name) throws SQLException;

	public MatrimonyDTO fetchByID(int id) throws SQLException;

	public void updateHabbitsByRegName(String habbit, String name) throws SQLException;

	public MatrimonyDTO fetchByRegisterNameAndQualification(String name, String qal) throws SQLException;

	
	
	public MatrimonyDTO fetchByIdAndGender(int id, Gender gender) throws SQLException;
	
	
	

	public void deleteByRegNameAndGenderAndQualification(String name, Gender gender, String qua) throws SQLException;

	public int getTotalRow() throws SQLException;

	public MatrimonyDTO fecthGenderAndRegName(Gender gender, String regName) throws SQLException;

	public void updateQualifectionByRegNameAndDeleteByID(String qua, String regName, int deleteID) throws SQLException;

	public MatrimonyDTO fetchByIDAndUpdateQualificationByRegName(int id, String qua, String regName)
			throws SQLException;

}
