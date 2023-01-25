package com.app.report.serviceInter;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.app.report.entity.Plans;
import com.app.report.entity.SearchRequest;
import com.app.report.entity.UserReports;

public interface ServiceInterface {

	public List<String> findByPlanName();

	public List<String> findByPlanStatus();

	public List<UserReports> getUserReportsPlans(SearchRequest request);

	
	public void exportExcel(HttpServletResponse response) throws Exception;
	
	public void exportPdf(HttpServletResponse response) throws Exception;
	
}