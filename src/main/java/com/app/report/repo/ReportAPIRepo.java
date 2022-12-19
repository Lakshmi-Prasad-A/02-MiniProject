package com.app.report.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.report.entity.ReportAPIEntity;

public interface ReportAPIRepo extends JpaRepository<ReportAPIEntity, Integer> {

}
