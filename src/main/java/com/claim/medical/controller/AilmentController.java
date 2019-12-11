package com.claim.medical.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.claim.medical.entity.Ailment;
import com.claim.medical.service.AilmentService;

@RestController
@RequestMapping("/ailments")
public class AilmentController {
	
	@Autowired
	AilmentService ailmentService;
	
	@GetMapping("")
	public ResponseEntity<List<Ailment>> getAilments(){
		return ResponseEntity.ok().body(ailmentService.getAilments());
	}

}
