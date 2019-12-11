package com.claim.medical.controller;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.claim.medical.dto.LoginRequestDto;
import com.claim.medical.entity.Claim;
import com.claim.medical.entity.User;
import com.claim.medical.service.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

	@Mock
	private UserServiceImpl userServiceImpl;

	@InjectMocks
	private UserController userController;

	LoginRequestDto loginRequestDto = null;

	@Test
	public void userLoginTest() {
		List<Claim> claimlist = new ArrayList<Claim>();
		User user = new User();
		user.setUserName("yoga");
		user.setPassword("india");

		Claim claim = new Claim();
		claim.setAilmentType("fever");
		claim.setApproverComments("approved");
		claim.setClaimAmount(20009.9);
		claim.setDiagnosis("stage");
		claim.setClaimStatus("Approved");
		claim.setClaimId(534634L);
		claim.setDoctorFee(345.90);
		claim.setPolicyNumber(56456456L);
		claim.setName("yoga");
		claim.setMedicalFee(454.54);
		claim.setHospitalName("Narayana");
		claim.setDischargeSummary("Discharged");
		claim.setDischargeDate(LocalDate.now());
		claim.setAdmittedDate(LocalDate.now());
		claim.setClaimDate(LocalDate.now());
		claimlist.add(claim);

		Mockito.when(userServiceImpl.userLogin(loginRequestDto)).thenReturn(claimlist);
		ResponseEntity<List<Claim>> claimList = userController.userLogin(loginRequestDto);
		assertNotNull(claimList);
	}

}
