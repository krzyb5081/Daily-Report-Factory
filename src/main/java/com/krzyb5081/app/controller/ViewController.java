package com.krzyb5081.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ViewController {

	@GetMapping("/")
	public String react() {
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
	public String postCreateReport() {
		return "createReport";
	}
}