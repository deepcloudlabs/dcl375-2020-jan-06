package com.example.world.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.RequestScope;

import com.example.world.dao.CountryDao;
import com.example.world.domain.Country;

@Controller
@RequestMapping("list")
@RequestScope 
public class WorldAjaxController {
	@Autowired CountryDao countryDao;
	@GetMapping
	public String home(Model model) {
		Set<String> continents = 
				countryDao.getAllContinents();
		model.addAttribute("continents", continents);
		return "home";
	}
	@PostMapping
	public String doSearch(Model model,String continent) {
		List<Country> countries = 
				countryDao.findCountriesByContinent(
						continent);
		System.err.println("continent="+continent);
		model.addAttribute("countries", countries);
		return "result";
	}
}



