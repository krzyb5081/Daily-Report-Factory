package com.krzyb5081.app.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.krzyb5081.app.dto.ReportDto;

@Controller
public class MakeReportController {

	
	@PostMapping("/makeReport")
	public void addProduct(@Valid ReportDto report) {
		//productService.addReport(report);
	}
}
