package com.claim.medical.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claim.medical.constants.Constant;
import com.claim.medical.entity.Claim;
import com.claim.medical.exception.PolicyNotFoundException;
import com.claim.medical.repository.ClaimRepository;
import com.claim.medical.repository.PolicyRepository;

@Service
public class ClaimServiceImpl implements ClaimService {
	@Autowired
	ClaimRepository claimRepository;
	@Autowired 
	PolicyRepository policyRepository;


	@Override
	public Claim viewClaimDetails(Long claimId) throws PolicyNotFoundException {
		
		Optional<Claim> claim=claimRepository.findByClaimId(claimId);
		if(claim.isPresent()) {
			return claim.get();
			}else {
				throw new PolicyNotFoundException(Constant.POLICY_NOT_FOUND);
		}
	}
}
		
			
			
			
			
	



	
