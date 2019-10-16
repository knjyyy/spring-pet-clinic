package com.springframework.springpetclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "types")
public class PetType extends BaseEntity {
	
	@Column(name = "name")
	private String name;

	public String getPetName() {
		return name;
	}

	public void setPetName(String name) {
		this.name = name;
	}
}
