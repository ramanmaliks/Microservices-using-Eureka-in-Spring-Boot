package com.raman.microservices.clientservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raman.microservices.clientservice.entity.Citizen;
import com.raman.microservices.clientservice.repository.CitizenRepo;

@Service
public class CitizenService {

@Autowired 
CitizenRepo citizenRepo;

public List<Citizen> getbyVaccinationId(Integer id){
	List<Citizen> citizenList = citizenRepo.findByVaccinationCenterId(id);
	return citizenList;
}

public Citizen addCitizinen(Citizen newCitizen) {
	
	return citizenRepo.save(newCitizen);
}
}
