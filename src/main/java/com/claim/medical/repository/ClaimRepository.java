package com.claim.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.claim.medical.entity.Claim;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {

}
