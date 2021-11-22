package com.raman.microservices.vaccinationcenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raman.microservices.vaccinationcenter.entity.VaccinationCenter;


@Repository
public interface VaccinationCenterRepo extends JpaRepository<VaccinationCenter, Integer> {

	
}
