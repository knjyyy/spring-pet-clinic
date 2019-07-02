package com.springframework.springpetclinic.services;

import java.util.Set;

import com.springframework.springpetclinic.model.Vet;

public interface VetService {

	Vet findById(Long id);
	Vet save(Vet vet);
	Set<Vet> findAll();
}
