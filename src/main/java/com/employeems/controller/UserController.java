package com.employeems.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeems.dto.RegisterRequest;
import com.employeems.dto.VerifyOtpRequest;
import com.employeems.service.OtpService;
import com.employeems.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private UserService userService;
	private OtpService otpService;
	
	public UserController(UserService userService,OtpService otpService) {
		this.userService = userService;
		this.otpService=otpService;
	}

	@PostMapping("/register")
	public String register(@RequestBody RegisterRequest registerRequest) {
		return userService.register(registerRequest);
	}
	
	@PostMapping("/verify-otp")
	public String VerifyOtp(@RequestBody VerifyOtpRequest verifyOtpRequest) {
		 return otpService.VerifyOtp(verifyOtpRequest);
	}
}
