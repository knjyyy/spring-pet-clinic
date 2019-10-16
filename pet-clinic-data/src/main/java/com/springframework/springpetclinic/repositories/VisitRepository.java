package com.springframework.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springframework.springpetclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long>{

}
