package com.claim.medical.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claim.medical.entity.Hospital;
import com.claim.medical.repository.HospitalRepository;

@Service
public class HospitalServiceImpl implements HospitalService {

	@Autowired
	HospitalRepository hospitalRepository;

	@Override
	public List<Hospital> getHospitals() {
		return hospitalRepository.findAll();
	}

}
