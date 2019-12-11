package com.claim.medical.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.claim.medical.entity.Hospital;
import com.claim.medical.service.HospitalService;

@RestController
@RequestMapping("/hospitals")
public class HospitalController {

	@Autowired
	HospitalService hospitalService;

	@GetMapping("")
	public ResponseEntity<List<Hospital>> getHospitals() {
		return ResponseEntity.ok().body(hospitalService.getHospitals());
	}

}
