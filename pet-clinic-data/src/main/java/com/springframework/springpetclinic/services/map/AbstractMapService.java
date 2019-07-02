package com.springframework.springpetclinic.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.Id;

public abstract class AbstractMapService<T, ID> {

	protected Map<ID, T> map = new HashMap<>();
	
	Set<T> findAll(){
		return new HashSet<>(map.values());
	}
	
	T findById(Id id) {
		return map.get(id);
	}
	
	T save(ID id, T object) {
		map.put(id, object);
		return object;
	}
	
	void deleteById(Id id) {
		
		map.remove(id);
	}
	
	void delete(T object) {
		map.entrySet().removeIf(entry -> entry.getValue().equals(object));
	}
	
}
