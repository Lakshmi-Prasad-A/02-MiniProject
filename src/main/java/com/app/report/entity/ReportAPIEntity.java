package com.app.report.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="reportapi")
public class ReportAPIEntity {
	
	@Id
	@GeneratedValue
	@Column(name="uid")
	private Integer userId;
	private String name;
	private String email;
	private Integer mobilenum;
	private String gender;
	private Integer ssn;
	private String plan_status;
	
	@OneToMany
	@JoinColumn(name="uidFk")
	private List<PlanName> pl_name;
	
	

}
