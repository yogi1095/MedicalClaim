package com.claim.medical.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.claim.medical.dto.ClaimRequestDto;
import com.claim.medical.exception.InvalidClaimAmountException;
import com.claim.medical.exception.PolicyExpiredException;
import com.claim.medical.exception.PolicyHolderNotFoundException;
import com.claim.medical.exception.PolicyNotFoundException;
import com.claim.medical.service.ClaimService;

@RestController
@RequestMapping("/claims")
public class ClaimController {

	@Autowired
	ClaimService claimService;

	@PostMapping
	public ResponseEntity<Long> raiseClaim(@RequestBody ClaimRequestDto claimRequestDto)
			throws PolicyHolderNotFoundException, PolicyExpiredException, InvalidClaimAmountException,
			PolicyNotFoundException {
		return ResponseEntity.ok().body(claimService.raiseRequest(claimRequestDto));

	}

}
