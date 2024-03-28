package com.user.service.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.user.service.Payload.ApiResponse;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> ResourceNotFoundException(ResourceNotFoundException ex){
	String message = ex.getMessage();
	ApiResponse api = ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
	return new ResponseEntity<ApiResponse>(api, HttpStatus.NOT_FOUND);
	}
	
}
