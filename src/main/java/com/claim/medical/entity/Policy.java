package com.claim.medical.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Policy {
	
	@Id
	private Long policyNumber;
	private LocalDate startDate;
	private LocalDate endDate;
	private Double policyAmount;
	private String policyHolderName;
	

}
