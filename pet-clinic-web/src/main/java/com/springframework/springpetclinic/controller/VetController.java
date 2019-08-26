package com.springframework.springpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springframework.springpetclinic.services.VetService;

//@RequestMapping("/vets")
@Controller
public class VetController {
	
	public final VetService vetService;
	
	public VetController(VetService vetService) {
		this.vetService = vetService;
	}
	
	//@RequestMapping({"", "/", "/index", "/index.html", ".html"})
	@RequestMapping({"/vets", "/vets/", "/vets/index", "/vets/index.html", "/vets.html"})
	public String listVets(Model model) {
		model.addAttribute("vets", vetService.findall());
		return "vets/index";
	}
}
