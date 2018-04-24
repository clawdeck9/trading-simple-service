package com.cluster9.cloudtradingservice.service;
 
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cluster9.cloudtradingservice.dao.CompanyRepo;
import com.cluster9.cloudtradingservice.entities.Company;
@RefreshScope
@RestController
public class CompanyRestService {
	int number = (int) (Math.random()*100);
	@Value("${specific}")
	String prop;
	@Autowired
	CompanyRepo repo;
	@RequestMapping("/spec")
	public String specific(){
		System.out.println("spec=" + prop);
		return prop;
	}
	@RequestMapping("/state")
	public String sendPage(){
		System.out.println("response from Company restservice number : " + number);
		return "(available)";
	}
	@RequestMapping("/companylist")
	public List<Company> getCompanyList(){
		return repo.findAll();
	}
}
