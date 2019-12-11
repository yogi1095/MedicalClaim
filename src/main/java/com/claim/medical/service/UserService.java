package com.claim.medical.service;

import java.util.List;

import com.claim.medical.dto.LoginRequestDto;
import com.claim.medical.entity.Claim;

/**
 * This service is having all the methods of the User.
 * 
 * @author Yoga
 */
public interface UserService {
	/**
	 * This method is used authenticate the customer.
	 * 
	 * @param loginRequestDto.This is object of the class LoginRequestDto which has
	 *                             all the fields.
	 * @return This has the return type of List of Claim Requests.
	 */
	public List<Claim> userLogin(LoginRequestDto loginRequestDto);

}
