package com.claim.medical.service;

import org.springframework.stereotype.Service;

import com.claim.medical.dto.ApproveClaimRequestDto;
import com.claim.medical.dto.ClaimRequestDto;
import com.claim.medical.entity.Claim;
import com.claim.medical.exception.AlreadyClaimedException;
import com.claim.medical.exception.InvalidClaimAmountException;
import com.claim.medical.exception.PolicyExpiredException;
import com.claim.medical.exception.PolicyHolderNotFoundException;
import com.claim.medical.exception.PolicyNotFoundException;

@Service
public interface ClaimService {

	Claim viewClaimDetails(Long claimId) throws PolicyNotFoundException;

	public Long raiseRequest(ClaimRequestDto claimRequestDto) throws PolicyHolderNotFoundException,
			PolicyExpiredException, InvalidClaimAmountException, PolicyNotFoundException, AlreadyClaimedException;

	public String approverClaimResponse(ApproveClaimRequestDto approveClaimRequestDto);
}
