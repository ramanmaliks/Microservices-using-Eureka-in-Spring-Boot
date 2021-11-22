package com.raman.microservices.clientservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raman.microservices.clientservice.entity.Citizen;
@Repository
public interface CitizenRepo extends JpaRepository<Citizen, Integer>{

	public List<Citizen> findByVaccinationCenterId(Integer id);
	
	
}
