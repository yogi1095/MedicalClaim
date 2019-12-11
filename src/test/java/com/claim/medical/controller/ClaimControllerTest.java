package com.claim.medical.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.claim.medical.dto.ClaimRequestDto;
import com.claim.medical.entity.Claim;
import com.claim.medical.exception.InvalidClaimAmountException;
import com.claim.medical.exception.PolicyExpiredException;
import com.claim.medical.exception.PolicyHolderNotFoundException;
import com.claim.medical.exception.PolicyNotFoundException;
import com.claim.medical.service.ClaimService;

@RunWith(MockitoJUnitRunner.class)
public class ClaimControllerTest {

	@InjectMocks
	ClaimController claimController;

	@Mock
	ClaimService claimService;

	ClaimRequestDto claimRequestDto = null;

	@Test
	public void raiseClaim() throws PolicyHolderNotFoundException, PolicyExpiredException, InvalidClaimAmountException,
			PolicyNotFoundException {
		claimRequestDto = new ClaimRequestDto();
		claimRequestDto.setAdmittedDate(LocalDate.of(2019, 12, 01));
		claimRequestDto.setAilmentType("maternity");
		claimRequestDto.setClaimAmount(10000.0);
		claimRequestDto.setDiagnosis("maternity");
		claimRequestDto.setDischargeDate(LocalDate.of(2019, 12, 03));
		claimRequestDto.setDischargeSummary("summary");
		claimRequestDto.setDoctorFee(1000.0);
		claimRequestDto.setHospitalName("priyahospital");
		claimRequestDto.setMedicalFee(10000.0);
		claimRequestDto.setName("name");
		claimRequestDto.setPolicyHolderId(12345L);
		claimRequestDto.setPolicyNumber(123L);
		Claim claim = new Claim();
		claim.setClaimId(123L);
		Mockito.when(claimService.raiseRequest(claimRequestDto)).thenReturn(12345L);
		ResponseEntity<Long> actual = claimController.raiseClaim(claimRequestDto);
		assertEquals(HttpStatus.OK, actual.getStatusCode());
	}

}
