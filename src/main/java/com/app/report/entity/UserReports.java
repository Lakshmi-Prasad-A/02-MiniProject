package com.app.report.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="userReports")
public class UserReports {
	
	@Id
	@GeneratedValue
	@Column(name="uid")
	private Integer userId;
	private String name;
	private String email;
	private Integer mobilenum;
	private String gender;
	private Integer ssn;
	private String planStatus;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="uidFk")
	private Plans plan;
	
	

}
