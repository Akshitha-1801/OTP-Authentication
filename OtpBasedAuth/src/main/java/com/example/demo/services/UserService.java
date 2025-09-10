package com.example.demo.services;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Token;
import com.example.demo.entities.User;
import com.example.demo.repositories.TokenRepository;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {
	
	UserRepository userRepository;
	TokenRepository tokenRepository; 
	JavaMailSender javaMailSender;
	
	public UserService(UserRepository userRepository, TokenRepository tokenRepository, JavaMailSender javaMailSender) {
		this.userRepository=userRepository;
		this.tokenRepository=tokenRepository;
		this.javaMailSender=javaMailSender;
	}

	public String verifyUser(String username, String password) {
		User user=userRepository.findByUsername(username);
		if(user!=null && password.equals(user.getPassword())){
			//generate otp token
			String otp = String.format("%06d", new Random().nextInt(999999));
			//create token object to store in db
			
			Token token = new Token();
			token.setUser(user);
			token.setOtp(otp);
			token.setCreatedAt(LocalDateTime.now());
			tokenRepository.save(token);
			
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(user.getEmail());
			message.setSubject("Your OTP Code");
			message.setText("Your OTP code is: "+ otp);
			javaMailSender.send(message);
			
			return "success";
		}else {
			return "failure";
		}
	}
	
	public String verifyOtp(String otp) {
		Token token=tokenRepository.findByOtp(otp);
		if(token!=null) {
			if(ChronoUnit.MINUTES.between(token.getCreatedAt(), LocalDateTime.now())>1) {
				tokenRepository.delete(token);
				return "expired";
			}
			return "success";
		}
		return "failure";
	}
}
