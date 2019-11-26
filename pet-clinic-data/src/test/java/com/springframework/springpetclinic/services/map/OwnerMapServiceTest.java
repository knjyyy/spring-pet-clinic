package com.springframework.springpetclinic.services.map;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.springframework.springpetclinic.model.Owner;
import com.springframework.springpetclinic.services.PetService;
import com.springframework.springpetclinic.services.PetTypeService;

class OwnerMapServiceTest {

	OwnerMapService ownerMapService;
	Owner owner1;
	Owner owner2;
	Owner owner4;
	long id1 = 1L;
	long id2 = 2L;
	long size = 0l;
	String lastName = "Jones";
	
	@BeforeEach
	void setUp() throws Exception {
		ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());		
		owner1 = Owner.builder().id(id1).firstName("John").lastName("Jones").build();
		
		ownerMapService.save(owner1);
		size++;
	}

	@Test
	void testDeleteById() {
		ownerMapService.deleteById(id1);
		size--;
		assertEquals(size, ownerMapService.findAll().size());
	}

	@Test
	void testFindall() {
		Set<Owner> owners = ownerMapService.findAll();
		assertEquals(size, (long) owners.size());
	}

	@Test
	void testFindByIdLong() {
		Owner ownerById = ownerMapService.findById(id1);
		assertEquals(owner1, ownerById);
	}

	@Test
	void testSaveOwnerExistingId() {
		owner2 = Owner.builder().id(id2).firstName("Tom").lastName("Jones").build();
		Owner ownerSaved = ownerMapService.save(owner2);
		size++;
		assertEquals(owner2, ownerSaved);
	}
	
	@Test
	void testSaveOwnerNoId() {
		owner2 = Owner.builder().firstName("Tom").lastName("Jones").build();
		Owner ownerSaved = ownerMapService.save(owner2);
		size++;
		assertEquals(owner2, ownerSaved);
	}

	@Test
	void testDeleteOwner() {
		ownerMapService.deleteById(id1);
		assertEquals(0, ownerMapService.findAll().size());
	}

	@Test
	void testFindByLastName() {
		Owner ownerFind = ownerMapService.findByLastName(lastName);
		assertEquals(lastName, ownerFind.getLastName());
	}

	@Test
	void testFindByLastNameNull() {
		String lastNameNull = "Smith";
		Owner ownerFind = ownerMapService.findByLastName(lastNameNull);
		assertNull(ownerFind);
	}

}
