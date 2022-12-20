package com.app.report.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.app.report.entity.UserReports;
import com.app.report.serviceInter.ServiceInterface;


@RestController
public class Controller {

	@Autowired
	private ServiceInterface ser;
	
	
	@GetMapping("/plans")
	public List<UserReports> findAll(){
		return ser.findAll();
	}
	
	@GetMapping("/plan") 
	public List<UserReports> findByPlanName(@RequestParam("planName") String planName){
		return ser.findByPlanName(planName);
	
	}
	@GetMapping("/status")
	public List<UserReports> findByStatus(@RequestParam("statusName") String statusName){
		return ser.findByStatus(statusName);
	}
	
	@GetMapping("/planStatus")
	public List<UserReports> findByNameAndStatus(@RequestParam("planName") String planName, @RequestParam("status") String status){
		return ser.findByNameAndStatus(planName, status);
	}
	

	
}
