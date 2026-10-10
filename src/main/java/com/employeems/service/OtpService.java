package com.employeems.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.employeems.dto.VerifyOtpRequest;
import com.employeems.entity.User;
import com.employeems.exception.InvalidOtpException;
import com.employeems.exception.OtpAlreadyUsedException;
import com.employeems.exception.OtpExpiryException;
import com.employeems.exception.UserNotFoundException;
import com.employeems.repository.UserRepository;

@Service
public class OtpService {

    private UserRepository userRepository;

    public OtpService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String VerifyOtp(VerifyOtpRequest verifyOtpRequest) {

        Optional<User> optionalUser = userRepository.findByEmail(verifyOtpRequest.getEmail());

        if (optionalUser.isPresent()) {

            User user = optionalUser.get();
            
            if (Boolean.TRUE.equals(user.isVerified()) || user.getOtp() == null) {
                throw new OtpAlreadyUsedException(
                    "This OTP has already been used or verification is already complete. Please login or request a new OTP.");
            }

            // Compare entered OTP with stored OTP
            if (!user.getOtp().equals(verifyOtpRequest.getOtp())) {
                throw new InvalidOtpException("invalid otp");
            }

            // Check expiry
            if (LocalDateTime.now().isAfter(user.getOtpexpirytime())) {
                throw new OtpExpiryException("otp expired");
            }

            // Verify user
            user.setVerified(true);
            user.setOtp(null);
            user.setOtpexpirytime(null);

            userRepository.save(user);

            return "OTP Verified Successfully";

        } else {
           throw new UserNotFoundException("no user found");
        }
    }
}