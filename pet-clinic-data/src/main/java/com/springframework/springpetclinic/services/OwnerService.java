package com.springframework.springpetclinic.services;

import java.util.Set;

import com.springframework.springpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
	
	Owner findByLastName(String lastName);
	
}
