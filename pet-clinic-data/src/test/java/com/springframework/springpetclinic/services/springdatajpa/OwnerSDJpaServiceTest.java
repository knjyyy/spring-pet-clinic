package com.springframework.springpetclinic.services.springdatajpa;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.springframework.springpetclinic.model.Owner;
import com.springframework.springpetclinic.repositories.OwnerRepository;
import com.springframework.springpetclinic.repositories.PetRepository;
import com.springframework.springpetclinic.repositories.PetTypeRepository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

	@Mock
	OwnerRepository ownerRepository;

	@Mock
	PetRepository petRepository;

	@Mock
	PetTypeRepository petTypeRepository;

	@InjectMocks
	OwnerSDJpaService service;

	Owner ownerMock;
	String lastName = "Doe";
	long size = 0;
	long id1 = 1l;
	long id2 = 2l;

	@BeforeEach
	void setUp() throws Exception {
		ownerMock = Owner.builder().id(1l).firstName("John").lastName(lastName).build();
	}

	@Test
	void testFindall() {
		Set<Owner> ownersMock = new HashSet<>();
		ownersMock.add(Owner.builder().id(id1).build());
		size++;
		ownersMock.add(Owner.builder().id(id2).build());
		size++;

		when(ownerRepository.findAll()).thenReturn(ownersMock);

		Set<Owner> owners = service.findAll();

		assertNotNull(owners);
		assertEquals(size, owners.size());
	}

	@Test
	void testFindByLastName() {

		when(ownerRepository.findByLastName(any())).thenReturn(ownerMock);
		Owner ownerLastName = service.findByLastName(lastName);
		assertEquals(lastName, ownerLastName.getLastName());
		verify(ownerRepository).findByLastName(any());
	}

	@Test
	void testFindById() {
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(ownerMock));
		Owner owner = service.findById(id1);
		assertNotNull(owner);
	}

	@Test
	void testFindByIdNotFound() {
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
		Owner owner = service.findById(id1);
		assertNull(owner);
	}

	@Test
	void testSave() {
		when(ownerRepository.save(any())).thenReturn(ownerMock);
		Owner owner = service.save(Owner.builder().id(1l).build());
		assertNotNull(owner);
		verify(ownerRepository).save(any());
	}

	@Test
	void testDelete() {
		service.delete(ownerMock);
		verify(ownerRepository, times(1)).delete(any());
	}

	@Test
	void testDeleteById() {
		service.delete(ownerMock);
		verify(ownerRepository, times(1)).delete(any());
	}

}
