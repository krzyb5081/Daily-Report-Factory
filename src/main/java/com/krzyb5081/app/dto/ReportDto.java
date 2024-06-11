package com.krzyb5081.app.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ReportDto {
	public String nameAndSurname;
	public String date;
	public String workTime;
	public String thingsDone;
	public String thingsToFinish;
	public String thingsUndone;
}
