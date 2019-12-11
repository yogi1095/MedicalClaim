package com.claim.medical.controller;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.claim.medical.entity.Hospital;
import com.claim.medical.service.HospitalService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class HospitalControllerTest {
	
	
	@InjectMocks
	HospitalController hospitalController;
	
	@Mock
	HospitalService hospitalService;
	
	@Test
	public void testGetHospitals() {

		Mockito.when(hospitalService.getHospitals()).thenReturn(new ArrayList<Hospital>());
		assertNotNull(hospitalController.getHospitals());
	}

}
