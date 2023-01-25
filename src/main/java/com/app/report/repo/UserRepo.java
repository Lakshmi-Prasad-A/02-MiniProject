package com.app.report.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.app.report.entity.UserReports;

public interface UserRepo extends JpaRepository<UserReports, Integer> {

	@Query("select distinct(planStatus) from UserReports")
	public List<String> findByPlanStatus();
	
	
//	@Query("select rep from UserReports rep join rep.plan p where p.planName=:planName and rep.planStatus=:planStatus")
//	public List<UserReports> getUserReportsPlans (@Param("planName") String planName, @Param("planStatus") String planStatus);

 
}
