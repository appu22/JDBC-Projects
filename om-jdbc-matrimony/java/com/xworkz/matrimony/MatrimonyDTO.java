package com.xworkz.matrimony;

public class MatrimonyDTO {

	private int mid;
	private String registerName;
	private Gender gender;
	private String lookingFor;
	private String qualification;
	private String habbits;

	public enum Gender {

		M, F, O
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getRegisterName() {
		return registerName;
	}

	public void setRegisterName(String registerName) {
		this.registerName = registerName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getLookingFor() {
		return lookingFor;
	}

	public void setLookingFor(String lookingFor) {
		this.lookingFor = lookingFor;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getHabbits() {
		return habbits;
	}

	public void setHabbits(String habbits) {
		this.habbits = habbits;
	}
	

}
