package com.app.report.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.report.entity.UserReports;

public interface UserRepo extends JpaRepository<UserReports, Integer> {

	@Query("select rep from UserReports rep join rep.plan p where p.planName=:planName")
	public List<UserReports> findByPlanName(@Param("planName") String planName);

	
	public List<UserReports> findByStatus(String status);
	
	@Query("select rep from UserReports rep join rep.plan p where p.planName=:planName and rep.status=:status")
	public List<UserReports> findByNameAndStatus (@Param("planName") String planName, @Param("status")String status);
	 
}
