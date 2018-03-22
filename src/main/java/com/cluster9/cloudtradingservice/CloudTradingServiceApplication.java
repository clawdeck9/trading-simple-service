package com.cluster9.cloudtradingservice;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

import com.cluster9.cloudtradingservice.dao.CompanyRepo;
import com.cluster9.cloudtradingservice.entities.Company;

@SpringBootApplication
public class CloudTradingServiceApplication {

	@Autowired
	CompanyRepo cr;
	
	public static void main(String[] args) {
		ApplicationContext ctxt = (ApplicationContext) SpringApplication.run(CloudTradingServiceApplication.class, args);
		CompanyRepo cr = ctxt.getBean(CompanyRepo.class);
		Stream.of("aa","bb","cc").forEach(name -> cr.save(new Company(name)));
		cr.findAll().forEach(c -> System.out.println("company name: " + c.getCompanyName()));
	}
}

// config class for repos
@Configuration
class CoRepoConfig extends RepositoryRestConfigurerAdapter{
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Company.class);
		
	}
}
