package com.springframework.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springframework.springpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
