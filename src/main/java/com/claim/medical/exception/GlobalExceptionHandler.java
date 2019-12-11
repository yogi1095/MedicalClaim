package com.claim.medical.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.claim.medical.constants.Constant;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ResponseError> UserNotFoundException(UserNotFoundException exception) {
		ResponseError errorResponse = new ResponseError();
		errorResponse.setMessage(Constant.USER_NOT_FOUND);
		errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	
	
	}

}
