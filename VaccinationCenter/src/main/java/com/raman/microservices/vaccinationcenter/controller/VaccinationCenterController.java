package com.raman.microservices.vaccinationcenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.raman.microservices.vaccinationcenter.entity.VaccinationCenter;
import com.raman.microservices.vaccinationcenter.model.Citizen;
import com.raman.microservices.vaccinationcenter.model.RequiredResponse;
import com.raman.microservices.vaccinationcenter.repository.VaccinationCenterRepo;




@RestController
@RequestMapping(path="/vaccinationcenter")
public class VaccinationCenterController {

	@Autowired
	private VaccinationCenterRepo repo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(path="/add", method =RequestMethod.POST)
	public ResponseEntity<VaccinationCenter> addCitizen(@RequestBody VaccinationCenter newVaccinationCenter){
		VaccinationCenter vaccCenter= repo.save(newVaccinationCenter);
		return new ResponseEntity<>(vaccCenter, HttpStatus.OK);
	}
	@GetMapping(path="/id/{id}")
	@HystrixCommand(fallbackMethod = "handleCitizenDownTime")
	public ResponseEntity<RequiredResponse> getAllDataBasedOnCenterId(@PathVariable Integer id){
		RequiredResponse requiredResponse = new RequiredResponse();
		//1st get vaccination center detail
		VaccinationCenter center = repo.findById(id).get();
		requiredResponse.setCenter(center);
		//2nd get all citizen regisered to vaccination center
		// List<Citizen> listofCitizens = restTemplate.getForObject("http://localhost:8081/citizen/id/"+id, List.class);
		List<Citizen> listofCitizens = restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/id/"+id, List.class);
		requiredResponse.setCitizen(listofCitizens);
		return new ResponseEntity<RequiredResponse>(requiredResponse, HttpStatus.OK);
	}

	public ResponseEntity<RequiredResponse> handleCitizenDownTime(@PathVariable Integer id){
		RequiredResponse requiredResponse = new RequiredResponse();
		//1st get vaccination center detail
		VaccinationCenter center = repo.findById(id).get();
		requiredResponse.setCenter(center);
		return new ResponseEntity<RequiredResponse>(requiredResponse, HttpStatus.OK);
	}
}
