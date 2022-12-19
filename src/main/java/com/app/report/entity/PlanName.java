package com.app.report.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="plan_name")

public class PlanName {
	@Id
	private Integer PlanId;
	private String PlanName;
}
