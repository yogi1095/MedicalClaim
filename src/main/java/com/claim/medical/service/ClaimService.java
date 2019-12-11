package com.claim.medical.service;

import org.springframework.stereotype.Service;

import com.claim.medical.entity.Claim;
import com.claim.medical.exception.PolicyNotFoundException;

@Service
public interface ClaimService {

	Claim viewClaimDetails(Long claimId) throws PolicyNotFoundException;

}
