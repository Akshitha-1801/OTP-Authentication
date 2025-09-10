package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.UserService;

@Controller
@RequestMapping("/api")
public class UserController {
	
	UserService userService;
	public UserController(UserService userService) {
		this.userService=userService;
	}

	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@PostMapping("/auth/login")
	public String verifyUser(@RequestParam("username") String username, @RequestParam("password") String password) {
		String result= userService.verifyUser(username, password);
		if(result.equalsIgnoreCase("success")) {
			return "success";
		}else {
			return "home";
		}
	}
	
	@PostMapping("/otp")
	public String verifyOtp(@RequestParam("otp") String otp) {
		String result=userService.verifyOtp(otp);
		if(result.equalsIgnoreCase("failure")) {
			return "success";
		}
		else if(result.equalsIgnoreCase("expired")) {
			return "home";
		}
		else {
			return "dashboard";
		}
		
	}
}
