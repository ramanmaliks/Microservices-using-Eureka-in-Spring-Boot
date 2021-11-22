package com.raman.microservices.vaccinationcenter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VaccinationCenter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "vacc_centre_name")
	private String centername;
	@Column(name = "vacc_centre_add")
	private String centerAddress;

	public VaccinationCenter() {
		super();
	}

	public VaccinationCenter(int id, String centername, String centerAddress) {
		super();
		this.id = id;
		this.centername = centername;
		this.centerAddress = centerAddress;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCentername() {
		return centername;
	}

	public void setCentername(String centername) {
		this.centername = centername;
	}

	public String getCenterAddress() {
		return centerAddress;
	}

	public void setCenterAddress(String centerAddress) {
		this.centerAddress = centerAddress;
	}

	@Override
	public String toString() {
		return "VacinationCenter [id=" + id + ", centername=" + centername + ", centerAddress=" + centerAddress + "]";
	}

}
