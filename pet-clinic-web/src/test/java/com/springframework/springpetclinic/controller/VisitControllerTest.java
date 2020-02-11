package com.springframework.springpetclinic.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.net.URI;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.UriTemplate;

import com.springframework.springpetclinic.model.Owner;
import com.springframework.springpetclinic.model.Pet;
import com.springframework.springpetclinic.model.PetType;
import com.springframework.springpetclinic.services.PetService;
import com.springframework.springpetclinic.services.VisitService;

@ExtendWith(MockitoExtension.class)
class VisitControllerTest {

	private static final String PETS_CREATE_UPDATE_VISIT_FORM = "pets/createOrUpdateVisitForm";
	private static final String REDIRECT_OWNERS_1 = "redirect:/owners/{ownerId}";
	private static final String VISIT_DESCRIPTION = "Another visit";
	
	@Mock
	PetService petService;
	
	@Mock
	VisitService visitService;
	
	@InjectMocks
	VisitController visitController;
	
	private MockMvc mockMvc;
	private final UriTemplate visitsUriTemplate = new UriTemplate("/owners/{ownerId}/pets/{petId}/visits/new");
	private final Map<String, String> uriVariables =  new HashMap<>();
	private URI visitsUri;
	
	@BeforeEach
	void setUp() throws Exception {
		Long petId = 1l;
		Long ownerId = 1l;
		
		when(petService.findById(anyLong()))
			.thenReturn(Pet.builder()
					.id(1l)
					.birthDate(LocalDate.of(2020, 02, 03))
					.name("Lazarus")
					.visits(new HashSet<>())
					.owner(Owner.builder()
							.id(ownerId)
							.firstName("Hope")
							.lastName("Pete")
							.build())
					.petType(PetType.builder()
							.name("Dog")
							.build())
					.build()
				);
		uriVariables.clear();
		uriVariables.put("ownerId", ownerId.toString());
		uriVariables.put("petId", petId.toString());
		visitsUri = visitsUriTemplate.expand(uriVariables);
		
		mockMvc = MockMvcBuilders.standaloneSetup(visitController).build();
	}

	@Test
	void initNewVisitForm() throws Exception {
		mockMvc.perform(get(visitsUri))
			.andExpect(status().isOk())
			.andExpect(view().name(PETS_CREATE_UPDATE_VISIT_FORM));
	}
	
	@Test
	void processNewVisitForm() throws Exception {
		mockMvc.perform(post(visitsUri)
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("date", "2020-02-03")
				.param("description", VISIT_DESCRIPTION))
			.andExpect(status().is3xxRedirection())
			.andExpect(view().name(REDIRECT_OWNERS_1))
			.andExpect(model().attributeExists("visit"));
	}

}
