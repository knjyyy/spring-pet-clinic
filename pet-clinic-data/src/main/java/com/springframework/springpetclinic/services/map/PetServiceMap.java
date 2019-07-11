package com.springframework.springpetclinic.services.map;

import java.util.Set;

import javax.persistence.Id;

import org.springframework.stereotype.Service;

import com.springframework.springpetclinic.model.Pet;
import com.springframework.springpetclinic.services.PetService;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

	@Override
	public Set<Pet> findall() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public Pet findById(Id id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public Pet save(Pet object) {
		// TODO Auto-generated method stub
		return super.save(object.getId(), object);
	}

	@Override
	public void delete(Pet object) {
		// TODO Auto-generated method stub
		super.delete(object);
	}

	@Override
	public void deleteById(Id id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}

}
