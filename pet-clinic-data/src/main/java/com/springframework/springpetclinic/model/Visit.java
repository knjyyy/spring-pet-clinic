package com.springframework.springpetclinic.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "visits")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Visit extends BaseEntity{

	@Column(name = "date")
    private LocalDate date;    
	
	@Column(name = "description")
    private String description;    
	
	@ManyToOne
	@JoinColumn(name = "pet_id")
    private Pet pet;
}
