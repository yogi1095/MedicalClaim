package com.claim.medical.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.claim.medical.constants.Constant;
import com.claim.medical.dto.ClaimRequestDto;
import com.claim.medical.entity.Claim;
import com.claim.medical.entity.PolicyHolder;
import com.claim.medical.exception.AlreadyClaimedException;
import com.claim.medical.exception.InvalidClaimAmountException;
import com.claim.medical.exception.PolicyExpiredException;
import com.claim.medical.exception.PolicyHolderNotFoundException;
import com.claim.medical.exception.PolicyNotFoundException;
import com.claim.medical.repository.ClaimRepository;
import com.claim.medical.repository.PolicyHolderRepository;

@RunWith(MockitoJUnitRunner.class)
public class ClaimServiceTest {
	
	private static final Optional<Claim> Claim = null;

	@InjectMocks
	ClaimServiceImpl claimServiceImpl;

	@Mock
	ClaimRepository claimRepository;

	@Mock
	PolicyHolderRepository policyHolderRepository;

	ClaimRequestDto claimRequestDto = null;
	Claim claim = null;
	PolicyHolder policyHolder = null;

	@Test
	public void raiseClaimTestPositive() throws PolicyHolderNotFoundException, PolicyExpiredException,
			InvalidClaimAmountException, PolicyNotFoundException, AlreadyClaimedException {
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
		policyHolder = new PolicyHolder();
		policyHolder.setPolicyHolderId(12345L);
		policyHolder.setPolicyNumber(123L);
		policyHolder.setPolicyHolderName("priya");
		policyHolder.setPolicyAmount(10000.0);
		policyHolder.setStartDate(LocalDate.of(2019, 05, 15));
		policyHolder.setEndDate(LocalDate.of(2020, 05, 15));
		claim = new Claim();
		claim.setClaimId(1234L);
		claim.setAdmittedDate(claimRequestDto.getAdmittedDate());
		claim.setAilmentType(claimRequestDto.getAilmentType());
		claim.setApproverComments("set");
		claim.setClaimAmount(claimRequestDto.getClaimAmount());
		claim.setClaimDate(LocalDate.now());
		claim.setClaimStatus(Constant.CLAIM_PENDING_STAGE_1);
		claim.setDiagnosis(claimRequestDto.getDiagnosis());
		claim.setDischargeDate(claimRequestDto.getDischargeDate());
		claim.setDischargeSummary(claimRequestDto.getDischargeSummary());
		claim.setDoctorFee(claimRequestDto.getDoctorFee());
		claim.setHospitalName(claimRequestDto.getHospitalName());
		claim.setMedicalFee(claimRequestDto.getMedicalFee());
		claim.setName(claimRequestDto.getName());
		Mockito.when(policyHolderRepository.findById(12345L)).thenReturn(Optional.of(policyHolder));
		claim.setPolicyHolder(policyHolder);
		claim.setPolicyNumber(claimRequestDto.getPolicyNumber());
		claimServiceImpl.raiseRequest(claimRequestDto);
		assertEquals(1234L, claim.getClaimId());
	}

	@Test(expected = PolicyHolderNotFoundException.class)
	public void raiseClaimTestPolicyHolderNotFound() throws PolicyHolderNotFoundException, PolicyExpiredException,
			InvalidClaimAmountException, PolicyNotFoundException, AlreadyClaimedException {
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
		policyHolder = new PolicyHolder();
		policyHolder.setPolicyHolderId(12345L);
		policyHolder.setPolicyNumber(123L);
		policyHolder.setPolicyHolderName("priya");
		policyHolder.setPolicyAmount(10000.0);
		policyHolder.setStartDate(LocalDate.of(2019, 05, 15));
		policyHolder.setEndDate(LocalDate.of(2020, 05, 15));
		// Mockito.when(policyHolderRepository.findById(1235L)).thenReturn(Optional.of(policyHolder));
		claimServiceImpl.raiseRequest(claimRequestDto);
	}

	@Test(expected = PolicyNotFoundException.class)
	public void raiseClaimTestPolicyNotFound() throws PolicyHolderNotFoundException, PolicyExpiredException,
			InvalidClaimAmountException, PolicyNotFoundException, AlreadyClaimedException {
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
		claimRequestDto.setPolicyNumber(1239L);
		policyHolder = new PolicyHolder();
		policyHolder.setPolicyHolderId(12345L);
		policyHolder.setPolicyNumber(123L);
		policyHolder.setPolicyHolderName("priya");
		policyHolder.setPolicyAmount(10000.0);
		policyHolder.setStartDate(LocalDate.of(2019, 05, 15));
		policyHolder.setEndDate(LocalDate.of(2020, 05, 15));
		Mockito.when(policyHolderRepository.findById(12345L)).thenReturn(Optional.of(policyHolder));
		claimServiceImpl.raiseRequest(claimRequestDto);
	}

	@Test(expected = InvalidClaimAmountException.class)
	public void raiseClaimTestInvalidClaimAmount() throws PolicyHolderNotFoundException, PolicyExpiredException,
			InvalidClaimAmountException, PolicyNotFoundException, AlreadyClaimedException {
		claimRequestDto = new ClaimRequestDto();
		claimRequestDto.setAdmittedDate(LocalDate.of(2019, 12, 01));
		claimRequestDto.setAilmentType("maternity");
		claimRequestDto.setClaimAmount(0.0);
		claimRequestDto.setDiagnosis("maternity");
		claimRequestDto.setDischargeDate(LocalDate.of(2019, 12, 03));
		claimRequestDto.setDischargeSummary("summary");
		claimRequestDto.setDoctorFee(1000.0);
		claimRequestDto.setHospitalName("priyahospital");
		claimRequestDto.setMedicalFee(10000.0);
		claimRequestDto.setName("name");
		claimRequestDto.setPolicyHolderId(12345L);
		claimRequestDto.setPolicyNumber(123L);
		policyHolder = new PolicyHolder();
		policyHolder.setPolicyHolderId(12345L);
		policyHolder.setPolicyNumber(123L);
		policyHolder.setPolicyHolderName("priya");
		policyHolder.setPolicyAmount(10000.0);
		policyHolder.setStartDate(LocalDate.of(2019, 05, 15));
		policyHolder.setEndDate(LocalDate.of(2020, 05, 15));
		Mockito.when(policyHolderRepository.findById(12345L)).thenReturn(Optional.of(policyHolder));
		claimServiceImpl.raiseRequest(claimRequestDto);
	}

	@Test(expected = PolicyExpiredException.class)
	public void raiseClaimTestAlreadyClaimed() throws PolicyHolderNotFoundException, PolicyExpiredException,
			InvalidClaimAmountException, PolicyNotFoundException, AlreadyClaimedException {
		claimRequestDto = new ClaimRequestDto();
		claimRequestDto.setAdmittedDate(LocalDate.of(2019, 12, 01));
		claimRequestDto.setAilmentType("maternity");
		claimRequestDto.setClaimAmount(100.0);
		claimRequestDto.setDiagnosis("maternity");
		claimRequestDto.setDischargeDate(LocalDate.of(2019, 12, 03));
		claimRequestDto.setDischargeSummary("summary");
		claimRequestDto.setDoctorFee(1000.0);
		claimRequestDto.setHospitalName("priyahospital");
		claimRequestDto.setMedicalFee(10000.0);
		claimRequestDto.setName("name");
		claimRequestDto.setPolicyHolderId(12345L);
		claimRequestDto.setPolicyNumber(123L);
		policyHolder = new PolicyHolder();
		policyHolder.setPolicyHolderId(12345L);
		policyHolder.setPolicyNumber(123L);
		policyHolder.setPolicyHolderName("priya");
		policyHolder.setPolicyAmount(10000.0);
		policyHolder.setStartDate(LocalDate.now());
		policyHolder.setEndDate(LocalDate.of(2020, 05, 15));
		Mockito.when(policyHolderRepository.findById(12345L)).thenReturn(Optional.of(policyHolder));
		claimServiceImpl.raiseRequest(claimRequestDto);
	}

	@Before
	public void setup() {
		Claim claim=new Claim();
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
	
	}


