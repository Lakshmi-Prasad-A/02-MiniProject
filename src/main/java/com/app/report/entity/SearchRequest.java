package com.app.report.entity;

import lombok.Data;

@Data
public class SearchRequest {
	
	private Integer planId;
	private String planName;
	private String planStatus;
}
