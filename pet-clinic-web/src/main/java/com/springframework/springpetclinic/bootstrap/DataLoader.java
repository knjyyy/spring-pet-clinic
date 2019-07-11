package com.springframework.springpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springframework.springpetclinic.model.Owner;
import com.springframework.springpetclinic.model.Vet;
import com.springframework.springpetclinic.services.OwnerService;
import com.springframework.springpetclinic.services.PetService;
import com.springframework.springpetclinic.services.VetService;
import com.springframework.springpetclinic.services.map.OwnerServiceMap;
import com.springframework.springpetclinic.services.map.PetServiceMap;
import com.springframework.springpetclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

	public final OwnerService ownerService;
	public final VetService vetService;
	
	public DataLoader(OwnerService ownerService, VetService vetService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Owner owner1 = new Owner();
		owner1.setId(1L);
		owner1.setFirstName("John");
		owner1.setLastName("Wetton");

		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setId(2L);
		owner2.setFirstName("Robert");
		owner2.setLastName("Fripp");

		ownerService.save(owner2);

		System.out.println("Loaded Owners....");

		Vet vet1 = new Vet();
		vet1.setId(1L);
		vet1.setFirstName("Bill");
		vet1.setLastName("Bruford");

		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setId(1L);
		vet2.setFirstName("Michael");
		vet2.setLastName("Giles");

		vetService.save(vet2);

		System.out.println("Loaded Vets....");
	}

}
