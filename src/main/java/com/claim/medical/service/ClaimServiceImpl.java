package com.claim.medical.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claim.medical.constants.Constant;
import com.claim.medical.dto.ClaimRequestDto;
import com.claim.medical.entity.Claim;
import com.claim.medical.entity.PolicyHolder;
import com.claim.medical.exception.InvalidClaimAmountException;
import com.claim.medical.exception.PolicyExpiredException;
import com.claim.medical.exception.PolicyHolderNotFoundException;
import com.claim.medical.exception.PolicyNotFoundException;
import com.claim.medical.repository.ClaimRepository;
import com.claim.medical.repository.PolicyHolderRepository;

@Service
public class ClaimServiceImpl implements ClaimService {

	@Autowired
	ClaimRepository claimRepository;

	@Autowired
	PolicyHolderRepository policyHolderRepository;

	@Override
	public Long raiseRequest(ClaimRequestDto claimRequestDto) throws PolicyHolderNotFoundException,
			PolicyExpiredException, InvalidClaimAmountException, PolicyNotFoundException {

		Claim claim = new Claim();
		Optional<PolicyHolder> policyHolder = policyHolderRepository.findById(claimRequestDto.getPolicyHolderId());

		if (!policyHolder.isPresent()) {
			throw new PolicyHolderNotFoundException(Constant.POLICY_HOLDER_NOT_FOUND);
		} else if (policyHolder.get().getPolicyNumber() != claimRequestDto.getPolicyNumber()) {
			throw new PolicyNotFoundException(Constant.POLICY_NOT_FOUND);
		} else if (!claimRequestDto.getAdmittedDate().isAfter(policyHolder.get().getStartDate())) {
			throw new PolicyExpiredException(Constant.POLICY_EXPIRED);
		} else if (claimRequestDto.getClaimAmount() <= 0) {
			throw new InvalidClaimAmountException(Constant.CLAIM_AMOUNT_INVALID);
		} else {
			claim.setPolicyHolder(policyHolder.get());
			claim.setName(claimRequestDto.getName());
			claim.setAilmentType(claimRequestDto.getAilmentType());
			claim.setClaimDate(LocalDate.now());
			claim.setDiagnosis(claimRequestDto.getDiagnosis());
			claim.setDischargeSummary(claimRequestDto.getDischargeSummary());
			claim.setHospitalName(claimRequestDto.getHospitalName());
			claim.setMedicalFee(claimRequestDto.getMedicalFee());
			claim.setDoctorFee(claimRequestDto.getDoctorFee());
			claim.setClaimStatus(Constant.CLAIM_PENDING_STAGE_1);
			claim.setAdmittedDate(claimRequestDto.getAdmittedDate());
			claim.setDischargeDate(claimRequestDto.getDischargeDate());
			claim.setClaimAmount(claimRequestDto.getClaimAmount());
			claimRepository.save(claim);
			return claim.getClaimId();
		}
	}

}
