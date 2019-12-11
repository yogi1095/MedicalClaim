package com.claim.medical.service;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.claim.medical.entity.Hospital;
import com.claim.medical.repository.HospitalRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class HospitalServiceTest {
	
	@InjectMocks
	HospitalServiceImpl hospitalServiceImpl;
	
	@Mock
	HospitalRepository hospitalRepository;
	
	@Test
	public void testGetHospitals() {
		
		Mockito.when(hospitalRepository.findAll()).thenReturn(new ArrayList<Hospital>());
		assertNotNull(hospitalServiceImpl.getHospitals());
	}
	

}
