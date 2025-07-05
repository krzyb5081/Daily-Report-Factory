package com.krzyb5081.app.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	
	@GetMapping("/login")
	public String login() {
		return "login";
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
	public ResponseEntity<Resource> postCreateReport(@Valid ReportDto reportDto) {
		System.out.print(reportDto.toString());
		try {
			File reportFile = generatorService.generateReport(reportDto);
			Resource resource = new ByteArrayResource(Files.readAllBytes(reportFile.toPath()));
			
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + reportFile.getName())
					.contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .contentLength(reportFile.length())
                    .body(resource);
			
		} catch (IOException e) {
			e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}