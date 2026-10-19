package com.krzyb5081.app.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ReportDto {
	private String nameAndSurname;
	private String date;
	private String workTime;
	private String thingsDone;
	private String thingsToFinish;
	private String thingsUndone;
	private Boolean weekDuty;
	private Boolean holidayDuty;
	private Boolean late;
}
