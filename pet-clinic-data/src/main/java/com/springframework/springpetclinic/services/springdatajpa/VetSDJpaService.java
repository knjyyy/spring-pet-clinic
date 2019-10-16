package com.springframework.springpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.springframework.springpetclinic.model.Vet;
import com.springframework.springpetclinic.repositories.VetRepository;
import com.springframework.springpetclinic.services.VetService;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {
	private final VetRepository vetRepository;
	
	public VetSDJpaService(VetRepository vetRepository) {
		this.vetRepository = vetRepository;
	}
	
	@Override
	public Set<Vet> findall() {
		Set<Vet> vets = new HashSet<>();
		vetRepository.findAll().forEach(vets::add);
		return vets;
	}

	@Override
	public Vet findById(Long id) {
		return vetRepository.findById(id).orElse(null);
	}

	@Override
	public Vet save(Vet object) {
		return vetRepository.save(object);
	}

	@Override
	public void delete(Vet object) {
		vetRepository.delete(object);		
	}

	@Override
	public void deleteById(Long id) {
		vetRepository.deleteById(id);
	}

}
