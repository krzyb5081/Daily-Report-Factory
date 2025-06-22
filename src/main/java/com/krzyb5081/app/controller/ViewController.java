package com.krzyb5081.app.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.krzyb5081.app.dto.ReportDto;
import com.krzyb5081.app.model.UserModel;
import com.krzyb5081.app.service.GeneratorService;
import com.krzyb5081.app.service.UserDetailsServiceImpl;

import jakarta.validation.Valid;

@Controller
public class ViewController {

	@Autowired
	GeneratorService generatorService;
	@Autowired
	UserDetailsServiceImpl userService;
	
	@GetMapping("/")
	public String slash() {
		return "index";
	}
	
	@GetMapping("/home")
	public String home() {
		return "index";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@PostMapping("/register")
	public String register(@Valid UserModel userModel) {
		userService.createUser(userModel);
		return "login";
	}
	
	@GetMapping("/showReports")
	public String showReports() {
		return "showReports";
	}
	
	@GetMapping("/createReport")
	public String getCreateReport() {
		
		return "createReport";
	}
	
	@PostMapping("/createReport")
	public String postCreateReport(@Valid ReportDto reportDto) {
		System.out.print(reportDto.toString());
		try {
			generatorService.generateReport(reportDto);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "showReport";
	}
}