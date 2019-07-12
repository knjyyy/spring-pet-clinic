package com.springframework.springpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springframework.springpetclinic.services.VetService;

@RequestMapping("/vets")
@Controller
public class VetController {
	
	public final VetService vetService;
	
	public VetController(VetService vetService) {
		this.vetService = vetService;
	}
	
	@RequestMapping({"", "/", "/index", "/index.html"})
	public String listVets(Model model) {
		model.addAttribute("vets", vetService.findall());
		return "vets/index";
	}
}
