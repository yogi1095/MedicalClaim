package com.claim.medical.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.claim.medical.entity.Ailment;

@Repository
public interface AilmentRepository extends JpaRepository<Ailment, Integer>{
	
	List<Ailment> findAll();

}
