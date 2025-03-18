package com.krzyb5081.app.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.krzyb5081.app.dto.ReportDto;

@Service
public class GeneratorService {
	public static String nameAndSurname = "Jan Kowalski";
	public static String date = "21.10.2024";
	public static String workTime = "8:00 - 16:00 (8 godzin)";
	public static String thingsDone = "Text here1, text here2, text here3, text here4, text here5ssssssssssssssssssssssssssssssssssssss, text here6, text here7, text here8, text here9, text here10, text here11, text here12, text here13, text here14.";
	public static String thingsToFinish = "Text here1, text here2, text here3, text here4, text here5, text here6, text here7, text here8, text here9, text here10, text here11, text here12, text here13, text here14.";
	public static String thingsUndone = "Text here1, text here2, text here3, text here4, text here5, text here6, text here7, text here8, text here9, text here10, text here11, text here12, text here13, text here14.";
	public static Boolean weekDuty = false;
	public static Boolean holidayDuty = false;
	public static Boolean late = false;
	
	public void generateReport(ReportDto report) throws IOException {

		TextWriter writer = new TextWriter("src/main/resources/generator/template.pdf","src/main/resources/generator/report.pdf");
		
		writer.openFile();
		
		writer.write(120, 700, report.getNameAndSurname());
		writer.write(300, 700, report.getDate());
		writer.write(400, 700, report.getWorkTime());
		writer.write(120, 600, report.getThingsDone());
		writer.write(120, 420, report.getThingsToFinish());
		writer.write(120, 260, report.getThingsUndone());
		
		
		writer.saveFile();
	}
}