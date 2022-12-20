package com.app.report.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.report.entity.Plans;
import com.app.report.entity.UserReports;
import com.app.report.repo.PlansRepo;
import com.app.report.repo.UserRepo;
import com.app.report.serviceInter.ServiceInterface;

@Service
public class ServiceImpl implements ServiceInterface {

	@Autowired
	private UserRepo urepo;
	
	@Autowired
	private PlansRepo prepo;

	@Override
	public List<UserReports> findAll() {
		
		return urepo.findAll();
	}

	@Override
	public List<UserReports> findByPlanName(String planName) {
		return urepo.findByPlanName(planName);
	}

	@Override
	public List<UserReports> findByStatus(String status) {
		return urepo.findByStatus(status);
	}

	@Override
	public List<UserReports> findByNameAndStatus(String planName, String status) {
		return urepo.findByNameAndStatus(planName, status);
	}

}
