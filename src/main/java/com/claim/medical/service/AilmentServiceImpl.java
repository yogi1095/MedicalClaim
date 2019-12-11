package com.claim.medical.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claim.medical.entity.Ailment;
import com.claim.medical.repository.AilmentRepository;

@Service
public class AilmentServiceImpl implements AilmentService {

	@Autowired
	AilmentRepository ailmentRepository;

	@Override
	public List<Ailment> getAilments() {

		return ailmentRepository.findAll();
	}

}
