package com.app.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.report.entity.Plans;
import com.app.report.entity.UserReports;
import com.app.report.repo.UserRepo;

@SpringBootApplication
public class ReportApiApplication implements ApplicationRunner {

	@Autowired
	private UserRepo repo;
	
	public static void main(String[] args) {
		SpringApplication.run(ReportApiApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		UserReports s1=new UserReports();
		UserReports s2=new UserReports();
		
		
		s1.setEmail("lakshminagu54@gmail.com");
		s1.setUserId(20);
		s1.setName("nagu");
		s1.setMobilenum(52258);
		s1.setGender("female");
		s1.setSsn(255852);
		s1.setPlanStatus("Approved");
		s1.setPlan(new Plans(null, "Arogya"));
		
		
		s2.setEmail("Veeru@gmail.com");
		s2.setUserId(21);
		s2.setName("veeru");
		s2.setMobilenum(552585);
		s2.setGender("male");
		s2.setSsn(86657);
		s2.setPlanStatus("Approved");
		s2.setPlan(new Plans(null, "Ayush"));
		
		repo.save(s1);
		repo.save(s2);
		
	}

}
