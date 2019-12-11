package com.claim.medical.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.claim.medical.entity.Claim;
import com.claim.medical.exception.PolicyNotFoundException;
import com.claim.medical.service.ClaimService;

@RestController
@RequestMapping("/claims")
public class ClaimController {
	@Autowired
	ClaimService claimService;

	/**
	 * @param claimId
	 * @return claimDetailsResponseDto will contain the status and approval flow of
	 *         a claim request
	 * @throws PolicyNotFoundException
	 */
	@GetMapping("/claimId")
	public ResponseEntity<Claim> claimDetails(@RequestParam("claimId") Long claimId) throws PolicyNotFoundException {
		return ResponseEntity.ok().body(claimService.viewClaimDetails(claimId));
	}
}
