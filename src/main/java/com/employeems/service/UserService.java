package com.employeems.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.employeems.dto.RegisterRequest;
import com.employeems.entity.User;
import com.employeems.repository.UserRepository;
import com.employeems.util.OtpGenerator;

@Service
public class UserService {

	private UserRepository userRepository;
	private EmailService emailService;

	
	public UserService(UserRepository userRepository, EmailService emailService) {
		this.userRepository = userRepository;
		this.emailService = emailService;
	}


	public String register(RegisterRequest registerRequest) {
		Optional<User> ou =userRepository.findByEmail(registerRequest.getEmail());
		if(ou.isPresent()) {
			return "Email_Id already exists";
		}
		else {
			User user=new User();
			user.setName(registerRequest.getName());
			user.setEmail(registerRequest.getEmail());
			user.setPassword(registerRequest.getPassword());
			user.setRole("USER_ROLE");
			user.setVerified(false);
			
			String otp=OtpGenerator.generateOtp();
			user.setOtp(otp);
			user.setOtpexpirytime(LocalDateTime.now().plusMinutes(5));
			
			userRepository.save(user);
			emailService.sendOtp(registerRequest.getEmail(), otp);
			return "please check your email for otp";
		}
	}
	
}
