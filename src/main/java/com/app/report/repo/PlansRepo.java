package com.app.report.repo;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.report.entity.Plans;


public interface PlansRepo extends JpaRepository<Plans, Integer> {

	@Query("select dinstinct(planName) from Plans")
	public List<String> findByPlanName();
	
	

	

}
