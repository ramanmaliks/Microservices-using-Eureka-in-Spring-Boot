package com.raman.microservices.vaccinationcenter.model;

import java.util.List;

import com.raman.microservices.vaccinationcenter.entity.VaccinationCenter;



public class RequiredResponse {
	private VaccinationCenter center;
	private List<Citizen> citizen;
	public RequiredResponse() {
		super();
		
	}
	public RequiredResponse(VaccinationCenter center, List<Citizen> citizen) {
		super();
		this.center = center;
		this.citizen = citizen;
	}
	public VaccinationCenter getCenter() {
		return center;
	}
	public void setCenter(VaccinationCenter center) {
		this.center = center;
	}
	public List<Citizen> getCitizen() {
		return citizen;
	}
	public void setCitizen(List<Citizen> citizen) {
		this.citizen = citizen;
	}
	@Override
	public String toString() {
		return "RequiredResponse [center=" + center + ", citizen=" + citizen + "]";
	} 

}
