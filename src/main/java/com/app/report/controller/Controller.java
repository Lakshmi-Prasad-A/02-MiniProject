package com.app.report.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.report.entity.SearchRequest;
import com.app.report.entity.UserReports;
import com.app.report.serviceInter.ServiceInterface;

@RestController
public class Controller {

	@Autowired
	private ServiceInterface ser;

	@GetMapping("/plan")
	public ResponseEntity<List<String>> findByPlanName() {
		List<String> planNames= ser.findByPlanName();
	return new ResponseEntity<>(planNames, HttpStatus.OK);
	}
	
	@GetMapping("/status") 
	public ResponseEntity<List<String>> findByPlanStatus() {
		List<String> planNames= ser.findByPlanStatus();
	return new ResponseEntity<>(planNames, HttpStatus.OK); 
		}
	

	@PostMapping("/search")
	public ResponseEntity<List<UserReports>> search (@RequestBody SearchRequest request){ 
		List<UserReports> userReports = ser.getUserReportsPlans(request);
		return new ResponseEntity<>(userReports, HttpStatus.OK);	
		}
	 @GetMapping("/excel")
	public void exportExcel(HttpServletResponse response) throws Exception{
	
	response.setContentType("application/octet-stream");
	
	String key = "Content-Disposition";
	String Value = "attachment;filename=UserReports.xls";
	
	response.setHeader(key, Value);
	
	ser.exportExcel(response);
	response.flushBuffer();
	}
	
	@GetMapping("/pdf")
	public void exportPdf(HttpServletResponse response) throws Exception{
		response.setContentType("application/pdf");
		
		String key = "Content-Disposition";
		String value = "attachment;filename = PDFreport.pdf";
		
		response.setHeader(key, value);
		
		ser.exportPdf(response);
		response.flushBuffer();
	}
}
