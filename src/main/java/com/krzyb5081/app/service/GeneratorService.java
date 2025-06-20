package com.krzyb5081.app.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.krzyb5081.app.dto.ReportDto;

@Service
public class GeneratorService {
	
	public void generateReport(ReportDto report) throws IOException {
		
		if(report.getWeekDuty() == null)report.setWeekDuty(false);
		if(report.getHolidayDuty() == null)report.setHolidayDuty(false);
		if(report.getLate() == null)report.setLate(false);

		TextWriter writer = new TextWriter("src/main/resources/generator/template.pdf","src/main/resources/generator/report.pdf");
		
		writer.openFile();
		
		writer.write(100, 720, "Pracownik: "+report.getNameAndSurname());
		writer.write(100, 700, "Dzien: "+report.getDate());
		writer.write(220, 700, "Czas pracy: "+report.getWorkTime());
		writer.write(100, 620, "Prace zrealizowane:");
		writer.write(100, 600, report.getThingsDone());
		writer.write(100, 440, "Prace do dokonczenia:");
		writer.write(100, 420, report.getThingsToFinish());
		writer.write(100, 280, "Prace niezrealizowane:");
		writer.write(100, 260, report.getThingsUndone());
		writer.write(120, 120, "Dyzur dzienny: "+report.getWeekDuty() != null ? "Tak" : "Nie");
		writer.write(120, 100, "Dyzur swiateczny: "+report.getHolidayDuty() != null ? "Tak" : "Nie");
		writer.write(120, 80, "Spoznienie: "+report.getLate() != null ? "Tak" : "Nie");
		
		
		
		
		writer.saveFile();
	}
}