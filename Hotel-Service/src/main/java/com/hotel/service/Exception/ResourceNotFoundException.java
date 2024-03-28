package com.hotel.service.Exception;

public class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException() {
		super("Hotels are not found on server");
	}
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
}
