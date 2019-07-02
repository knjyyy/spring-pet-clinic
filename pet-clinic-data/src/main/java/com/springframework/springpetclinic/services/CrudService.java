package com.springframework.springpetclinic.services;

import java.util.Set;

import javax.persistence.Id;

public interface CrudService<T, ID> {
	Set<T> findall();

	T findById(Id id);

	T save(T object);

	void delete(T object);

	void deleteById(Id id);
}
