package com.cluster9.cloudtradingservice.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cluster9.cloudtradingservice.entities.Company;
@RepositoryRestResource // seems both the rest controllers work fine without this annotation
public interface CompanyRepo extends JpaRepository<Company, Long>{
	
	@Query("select c from Company c where c.companyName like :kw")
	public Page<Company> companyByKeyword(@Param("kw") String kw, Pageable pageable);
}
