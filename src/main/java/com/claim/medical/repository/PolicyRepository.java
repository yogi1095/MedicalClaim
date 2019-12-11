package com.claim.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.claim.medical.entity.PolicyHolder;
@Repository
public interface PolicyRepository extends JpaRepository<PolicyHolder, Long>{

}
