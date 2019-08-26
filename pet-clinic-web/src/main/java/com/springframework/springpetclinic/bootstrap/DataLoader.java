package com.springframework.springpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springframework.springpetclinic.model.Owner;
import com.springframework.springpetclinic.model.Pet;
import com.springframework.springpetclinic.model.PetType;
import com.springframework.springpetclinic.model.Vet;
import com.springframework.springpetclinic.services.OwnerService;
import com.springframework.springpetclinic.services.PetService;
import com.springframework.springpetclinic.services.PetTypeService;
import com.springframework.springpetclinic.services.VetService;
import com.springframework.springpetclinic.services.map.OwnerServiceMap;
import com.springframework.springpetclinic.services.map.PetServiceMap;
import com.springframework.springpetclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	
	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}
	
	@Override
	public void run(String... args) throws Exception {
		PetType dog = new PetType();
		dog.setPetName("dog");
		PetType savedDogPetType = petTypeService.save(dog);

		PetType cat = new PetType();
		dog.setPetName("cat");
		PetType savedCatPetType = petTypeService.save(cat);
		
		Owner owner1 = new Owner();
		owner1.setFirstName("John");
		owner1.setLastName("Wetton");
		owner1.setAddress("Willington");
		owner1.setCity("Derbyshire");
		owner1.setTelephone("014-124-12");
		
		Pet johnsPet = new Pet();
		johnsPet.setName("Lark");
		johnsPet.setPetType(savedDogPetType);
		johnsPet.setOwner(owner1);
		johnsPet.setBirthDate(LocalDate.now());
		owner1.getPets().add(johnsPet);
		
		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setFirstName("Robert");
		owner2.setLastName("Fripp");
		owner2.setAddress("Wimborne Minster");
		owner2.setCity("East Dorset");
		owner2.setTelephone("011-902-78");
		
		Pet robertsCat = new Pet();
		robertsCat.setName("Retzius");
		robertsCat.setPetType(savedCatPetType);
		robertsCat.setOwner(owner2);
		robertsCat.setBirthDate(LocalDate.now());
		owner2.getPets().add(robertsCat);

		ownerService.save(owner2);

		System.out.println("Loaded Owners....");

		Vet vet1 = new Vet();
		vet1.setFirstName("Bill");
		vet1.setLastName("Bruford");

		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setFirstName("Michael");
		vet2.setLastName("Giles");

		vetService.save(vet2);

		System.out.println("Loaded Vets....");
	}

}
