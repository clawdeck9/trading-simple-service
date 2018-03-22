package com.cluster9.cloudtradingservice.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Company implements Serializable {
	@Id @GeneratedValue
	private Long id;
	private String companyName;
	
	public Company(Long id) {
		super();
		this.id = id;
	}
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public Company(String companyName) {
		super();
		this.companyName = companyName;
	}

}
