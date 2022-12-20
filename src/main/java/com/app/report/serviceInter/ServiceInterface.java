package com.app.report.serviceInter;


import java.util.List;

import com.app.report.entity.Plans;
import com.app.report.entity.UserReports;


public interface ServiceInterface {

	
	public List<UserReports> findAll();
	
	public List<UserReports> findByPlanName(String planName);
	
	public List<UserReports> findByStatus(String status);
	
	public List<UserReports> findByNameAndStatus (String planName, String status);
	
	
	
	

}