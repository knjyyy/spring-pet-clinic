package com.springframework.springpetclinic.services.map;

import java.util.Set;

import javax.persistence.Id;

import com.springframework.springpetclinic.model.Vet;
import com.springframework.springpetclinic.services.VetService;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

	@Override
	public Set<Vet> findall() {
		return super.findAll();
	}

	@Override
	public Vet findById(Id id) {
		return super.findById(id);
	}

	@Override
	public Vet save(Vet object) {
		return super.save(object.getId(), object);
	}

	@Override
	public void delete(Vet object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Id id) {
		super.deleteById(id);
	}

}
