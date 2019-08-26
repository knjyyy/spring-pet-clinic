package com.springframework.springpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.springframework.springpetclinic.model.Specialty;
import com.springframework.springpetclinic.services.SpecialtiesService;

@Service
public class SpecialtyMapService extends AbstractMapService<Specialty, Long> implements SpecialtiesService {

	@Override
	public Set<Specialty> findall() {
		return super.findAll();
	}

	@Override
	public Specialty findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Specialty save(Specialty object) {
		return super.save(object);
	}

	@Override
	public void delete(Specialty object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

}
