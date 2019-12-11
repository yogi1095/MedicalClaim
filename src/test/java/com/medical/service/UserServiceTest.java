package com.medical.service;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.claim.medical.dto.LoginRequestDto;
import com.claim.medical.entity.Claim;
import com.claim.medical.entity.Role;
import com.claim.medical.entity.User;
import com.claim.medical.repository.ClaimRepository;
import com.claim.medical.repository.UserRepository;
import com.claim.medical.service.UserServiceImpl;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserServiceTest {

	@Mock
	private UserRepository userRepository;
	@Mock
	private ClaimRepository claimRepository;

	@InjectMocks
	private UserServiceImpl userServiceImpl;

	LoginRequestDto loginRequestDto = null;
	User user = null;
	Claim claim = null;
	Role role = null;
	List<Claim> claimlist = new ArrayList<Claim>();

	@Before
	public void setUp() {
		loginRequestDto = new LoginRequestDto();
		loginRequestDto.setUserName("yoga");
		loginRequestDto.setPassword("india");
		user = new User();
		user.setUserName("yoga");
		user.setPassword("india");
		claim = new Claim();
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
	}

	@Test
	public void userLoginTest() {
		role = new Role();
		role.setRoleId(1);
		user.setRole(role);
		Mockito.when(userRepository.findByUserNameAndPassword(Mockito.anyString(), Mockito.anyString()))
				.thenReturn(Optional.of(user));
		List<Claim> claimList1 = userServiceImpl.userLogin(loginRequestDto);
		assertNotNull(claimlist);
	}

	@Test
	public void userLoginTest2() {
		role = new Role();
		role.setRoleId(2);
		user.setRole(role);
		Mockito.when(userRepository.findByUserNameAndPassword(Mockito.anyString(), Mockito.anyString()))
				.thenReturn(Optional.of(user));
		List<Claim> claimList1 = userServiceImpl.userLogin(loginRequestDto);
		assertNotNull(claimlist);
	}

	@Test
	public void userLoginNegativeTest() {
		role = new Role();
		role.setRoleId(3);
		user.setRole(role);
		Mockito.when(userRepository.findByUserNameAndPassword(Mockito.anyString(), Mockito.anyString()))
				.thenReturn(Optional.of(user));
		List<Claim> claimList1 = userServiceImpl.userLogin(loginRequestDto);
		assertNotNull(claimlist);
	}
}
