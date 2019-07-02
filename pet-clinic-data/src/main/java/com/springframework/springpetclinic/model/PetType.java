package com.springframework.springpetclinic.model;

public class PetType extends BaseEntity {
	private String name;

	public String getPetType() {
		return name;
	}

	public void setPetType(String name) {
		this.name = name;
	}
}
