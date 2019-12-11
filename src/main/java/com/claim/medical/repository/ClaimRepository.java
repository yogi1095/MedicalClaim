package com.claim.medical.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.claim.medical.entity.Claim;

/**
 * This Repository is having all the querys of Claims.
 * 
 * @author yoga
 */
@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {
	
	List<Claim> findAllByClaimStatus(String status);
}
