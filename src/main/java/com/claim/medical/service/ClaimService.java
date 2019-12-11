package com.claim.medical.service;

import com.claim.medical.dto.ClaimRequestDto;
import com.claim.medical.exception.InvalidClaimAmountException;
import com.claim.medical.exception.PolicyExpiredException;
import com.claim.medical.exception.PolicyHolderNotFoundException;
import com.claim.medical.exception.PolicyNotFoundException;

public interface ClaimService {

	public Long raiseRequest(ClaimRequestDto claimRequestDto) throws PolicyHolderNotFoundException,
			PolicyExpiredException, InvalidClaimAmountException, PolicyNotFoundException;

}
