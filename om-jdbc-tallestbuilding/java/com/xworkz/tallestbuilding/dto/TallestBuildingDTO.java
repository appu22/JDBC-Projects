package com.xworkz.tallestbuilding.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class TallestBuildingDTO {
	
	@NonNull
	private int id;
	@NonNull
	private String name;
	@NonNull
	private double length;
	@NonNull
	private String country;
	@NonNull
	private String constructedDate;
	@NonNull
	private String constructedBy;
	@NonNull
	private String area;
}
