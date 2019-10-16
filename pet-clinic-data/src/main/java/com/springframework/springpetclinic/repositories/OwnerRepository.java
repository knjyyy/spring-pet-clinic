package com.springframework.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springframework.springpetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long>{

	Owner findByLastName(String lastName);
}
