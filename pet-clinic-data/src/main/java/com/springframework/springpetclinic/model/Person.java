package com.springframework.springpetclinic.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person extends BaseEntity {
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;
}
