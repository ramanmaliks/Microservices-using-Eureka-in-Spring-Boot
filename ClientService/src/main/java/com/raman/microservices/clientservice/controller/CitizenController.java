package com.raman.microservices.clientservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.raman.microservices.clientservice.entity.Citizen;
import com.raman.microservices.clientservice.services.CitizenService;

@RestController
@RequestMapping("/citizen")
public class CitizenController {

	@Autowired
	public CitizenService citizenService;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ResponseEntity<String> test() {
		return new ResponseEntity<>("hello", HttpStatus.OK);
	}

	@RequestMapping(path = "/id/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Citizen>> getbyId(@PathVariable Integer id) {
		List<Citizen> listCitizen = citizenService.getbyVaccinationId(id);
		return new ResponseEntity<>(listCitizen, HttpStatus.OK);
	}
		@RequestMapping(path = "/add", method = RequestMethod.POST)
		public ResponseEntity<Citizen> addCitizine(@RequestBody Citizen newCitizen) {
			//System.out.println(newCitizen);
			Citizen citizen = citizenService.addCitizinen(newCitizen);
			
			return new ResponseEntity<>(citizen, HttpStatus.OK);
	
	}
}
