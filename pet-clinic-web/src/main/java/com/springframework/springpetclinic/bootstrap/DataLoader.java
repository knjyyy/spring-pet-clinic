package com.springframework.springpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springframework.springpetclinic.model.Owner;
import com.springframework.springpetclinic.model.Pet;
import com.springframework.springpetclinic.model.PetType;
import com.springframework.springpetclinic.model.Specialty;
import com.springframework.springpetclinic.model.Vet;
import com.springframework.springpetclinic.model.Visit;
import com.springframework.springpetclinic.services.OwnerService;
import com.springframework.springpetclinic.services.PetService;
import com.springframework.springpetclinic.services.PetTypeService;
import com.springframework.springpetclinic.services.SpecialtyService;
import com.springframework.springpetclinic.services.VetService;
import com.springframework.springpetclinic.services.VisitService;
import com.springframework.springpetclinic.services.map.OwnerMapService;
import com.springframework.springpetclinic.services.map.PetMapService;
import com.springframework.springpetclinic.services.map.VetMapService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialtyService specialtyService;
	private final VisitService visitService;
	
	public DataLoader(OwnerService ownerService, 
			VetService vetService, 
			PetTypeService petTypeService, 
			SpecialtyService specialtyService,
			VisitService visitService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialtyService = specialtyService;
		this.visitService = visitService;
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		int count = petTypeService.findAll().size();
		
		if(count == 0) {
			loadData();			
		}
	}

	private void loadData() {
		PetType dog = new PetType();
		dog.setName("dog");
		PetType savedDogPetType = petTypeService.save(dog);

		PetType cat = new PetType();
		cat.setName("cat");
		PetType savedCatPetType = petTypeService.save(cat);
		
		Specialty radiology = new Specialty();
		radiology.setDescription("Radiology");
		Specialty savedRadiology = specialtyService.save(radiology);

		Specialty surgery = new Specialty();
		surgery.setDescription("Surgery");
		Specialty savedSurgery = specialtyService.save(surgery);

		Specialty dentistry = new Specialty();
		dentistry.setDescription("Dentistry");
		Specialty savedDentistry = specialtyService.save(dentistry );
		
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
		
		Visit visit = new Visit();
		visit.setPet(robertsCat);
		visit.setDate(LocalDate.now());
		visit.setDescription("Smelly cat");
		
		visitService.save(visit);

		System.out.println("Loaded Owners....");

		Vet vet1 = new Vet();
		vet1.setFirstName("Bill");
		vet1.setLastName("Bruford");
		vet1.getSpecialties().add(savedRadiology);

		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setFirstName("Michael");
		vet2.setLastName("Giles");
		vet2.getSpecialties().add(savedSurgery);

		vetService.save(vet2);

		System.out.println("Loaded Vets....");
	}

}
