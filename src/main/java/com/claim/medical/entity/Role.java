package com.claim.medical.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Role {
	
	@Id
	private Integer roleId;
	private String roleName;

}
