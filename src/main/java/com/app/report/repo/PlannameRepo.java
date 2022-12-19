package com.app.report.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.report.entity.PlanName;

public interface PlannameRepo extends JpaRepository<PlanName, Integer> {

}
