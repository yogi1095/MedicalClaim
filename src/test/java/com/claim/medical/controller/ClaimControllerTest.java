package com.claim.medical.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
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
import com.claim.medical.exception.AlreadyClaimedException;
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
			PolicyNotFoundException, AlreadyClaimedException {
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

	private static final Claim Claim = null;

	@Before
	public void setup() {
		Claim claim = new Claim();
		claim.setAdmittedDate(LocalDate.parse("2019-09-09"));
		claim.setAilmentType("ddd");
		claim.setApproverComments("ddd");
		claim.setClaimAmount(500.00);
		claim.setClaimDate(LocalDate.parse("2019-07-05"));
		claim.setClaimStatus("Approved");
		claim.setDiagnosis("cancer");
		claim.setDischargeDate(LocalDate.parse("2019-08-02"));
		claim.setDischargeSummary("done");
		claim.setDoctorFee(200.00);
		claim.setHospitalName("moorthy hospital");
		claim.setMedicalFee(300.00);
		claim.setName("zzz");

	}

	@Test
	public void testClaimDetails() throws PolicyNotFoundException {
		Long claimId = 8888L;
		Mockito.when(claimService.viewClaimDetails(claimId)).thenReturn(Claim);
		ResponseEntity<Claim> response = claimController.claimDetails(claimId);
		Assert.assertNotNull(response);
	}

}
