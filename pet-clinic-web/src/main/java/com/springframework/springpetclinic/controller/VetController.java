package com.springframework.springpetclinic.controller;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springframework.springpetclinic.model.Vet;
import com.springframework.springpetclinic.services.VetService;

//@RequestMapping("/vets")
@Controller
public class VetController {
	
	public final VetService vetService;
	
	public VetController(VetService vetService) {
		this.vetService = vetService;
	}
	
	@RequestMapping({"/vets", "/vets/", "/vets/index", "/vets/index.html", "/vets.html"})
	public String listVets(Model model) {
		model.addAttribute("vets", vetService.findAll());
		return "vets/index";
	}
	
	@GetMapping({"/api/vets"})
	public @ResponseBody Set<Vet> getVetsJson() {
		return vetService.findAll();
	}
}
