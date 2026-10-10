package com.employeems.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling
{
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> invalidData(MethodArgumentNotValidException methodArgumentNotValidException){
		String message=methodArgumentNotValidException.getBindingResult().getFieldError().getDefaultMessage();
		return new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);	
		}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> userNotFound(UserNotFoundException userNotFoundException){
		return new ResponseEntity<String>(userNotFoundException.getMessage(),HttpStatus.NOT_FOUND);	
		}
		
	@ExceptionHandler(OtpAlreadyUsedException .class)
	public ResponseEntity<String> otpAlreadyUsed(OtpAlreadyUsedException  otpAlreadyUsedException){
		return new ResponseEntity<String>(otpAlreadyUsedException.getMessage(),HttpStatus.CONFLICT);	
		}
		
	
	@ExceptionHandler(InvalidOtpException.class)
	public ResponseEntity<String> invalidOtp(InvalidOtpException invalidOtpException){
		return new ResponseEntity<String>(invalidOtpException.getMessage(),HttpStatus.BAD_REQUEST);	
		}
	
	@ExceptionHandler(OtpExpiryException.class)
	public ResponseEntity<String> invalidOtp(OtpExpiryException otpExpiryException){
		return new ResponseEntity<String>(otpExpiryException.getMessage(),HttpStatus.BAD_REQUEST);	
		}
}
