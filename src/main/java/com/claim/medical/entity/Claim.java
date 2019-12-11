package com.claim.medical.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Claim {
	
	@Id
	private Long claimId;
	private String name;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "policyNumber")
	private Policy policy;
	private String diagnosis;
	private LocalDate admittedDate;
	private LocalDate dischargeDate;
	private Double claimAmount;
	private String hospitalName;
	private String dischargeSummary;
	private String ailmentType;
	private Double doctorFee;
	private Double medicalFee;
	private String claimStatus;
	private String approverComments;

}
