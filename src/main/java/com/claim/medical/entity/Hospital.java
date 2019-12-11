package com.claim.medical.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Hospital {

	@Id
	private Integer hospitalId;
	private String hospitalName;
<<<<<<< HEAD
	 
=======
	private String address;
>>>>>>> cde6184974b57e00ebf62c1787eaae9dd488e242

}
