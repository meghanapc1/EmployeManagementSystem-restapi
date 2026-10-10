package com.employeems.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class OtpExpiryException extends RuntimeException{

	public OtpExpiryException(String message) {
		super(message);
	}
}
