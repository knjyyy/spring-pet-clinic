package com.springframework.springpetclinic.services.map;

import java.util.Set;

import javax.persistence.Id;

import org.springframework.stereotype.Service;

import com.springframework.springpetclinic.model.PetType;
import com.springframework.springpetclinic.services.PetTypeService;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService  {

	@Override
	public Set<PetType> findall() {
		return super.findAll();
	}

	@Override
	public PetType findById(Long id) {
		return super.findById(id);
	}

	@Override
	public PetType save(PetType object) {
		return super.save(object);
	}

	@Override
	public void delete(PetType object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

}
