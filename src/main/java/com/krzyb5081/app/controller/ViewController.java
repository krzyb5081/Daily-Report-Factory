package com.krzyb5081.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.krzyb5081.app.dto.ReportDto;

import jakarta.validation.Valid;

@Controller
public class ViewController {

	@GetMapping("/")
	public String slash() {
		return "index";
	}
	
	@GetMapping("/home")
	public String home() {
		return "index";
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
		return "showReport";
	}
}