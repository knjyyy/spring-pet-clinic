package com.springframework.springpetclinic.model;

public class PetType extends BaseEntity {
	private String name;

	public String getPetName() {
		return name;
	}

	public void setPetName(String name) {
		this.name = name;
	}
}
