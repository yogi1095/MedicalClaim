package com.claim.medical.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claim.medical.constants.Constant;
import com.claim.medical.controller.UserController;
import com.claim.medical.dto.LoginRequestDto;
import com.claim.medical.entity.Claim;
import com.claim.medical.entity.User;
import com.claim.medical.exception.UserNotFoundException;
import com.claim.medical.repository.ClaimRepository;
import com.claim.medical.repository.UserRepository;

/**
 * This service is having all the implementations of methods of the User.
 * 
 * @author yoga
 */
@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	/**
	 * This will inject all the methods in the UserRepository.
	 */
	@Autowired
	private UserRepository userRepository;

	/**
	 * This will inject all the methods in the ClaimRepository.
	 */
	@Autowired
	private ClaimRepository claimRepository;

	/**
	 * This method is used authenticate the customer.
	 * 
	 * @param loginRequestDto.This is object of the class LoginRequestDto which has
	 *                             all the fields.
	 * @return This has the return type of claim which will contain list of claim
	 *         requests.
	 */
	@Override
	public List<Claim> userLogin(LoginRequestDto loginRequestDto) {
		Optional<User> user = userRepository.findByUserNameAndPassword(loginRequestDto.getUserName(),
				loginRequestDto.getPassword());
		List<Claim> claims = null;

		if (user.isPresent()) {
			if (user.get().getRole().getRoleId() == 1) {
				claims = claimRepository.findAllByClaimStatus(Constant.CLAIM_PENDING_STAGE_1);

			}
			if (user.get().getRole().getRoleId() == 2) {
				claims = claimRepository.findAllByClaimStatus(Constant.CLAIM_PENDING_STAGE_2);
			}
		} else {
			throw new UserNotFoundException(Constant.USER_NOT_FOUND);
		}
		return claims;

	}
}
