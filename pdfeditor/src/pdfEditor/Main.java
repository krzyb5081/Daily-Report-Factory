package pdfEditor;

import java.io.IOException;



public class Main {

	public static String nameAndSurname = "Jan Kowalski";
	public static String date = "21.10.2024";
	public static String workTime = "8:00 - 16:00 (8 godzin)";
	public static String thingsDone = "Text here1, text here2, text here3, text here4, text here5ssssssssssssssssssssssssssssssssssssss, text here6, text here7, text here8, text here9, text here10, text here11, text here12, text here13, text here14.";
	public static String thingsToFinish = "Text here1, text here2, text here3, text here4, text here5, text here6, text here7, text here8, text here9, text here10, text here11, text here12, text here13, text here14.";
	public static String thingsUndone = "Text here1, text here2, text here3, text here4, text here5, text here6, text here7, text here8, text here9, text here10, text here11, text here12, text here13, text here14.";
	public static bool late = false;
	public static bool dailyDuty = false;
	public static bool weekendDuty = false;
	
	
	public static void main(String[] args) throws IOException {
		TextWriter writer = new TextWriter("src/pdfeditor/template.pdf","src/pdfeditor/report.pdf");
		
		writer.openFile();
		
		writer.write(120, 700, nameAndSurname);
		writer.write(300, 700, date);
		writer.write(400, 700, workTime);
		writer.write(120, 600, thingsDone);
		writer.write(120, 420, thingsToFinish);
		writer.write(120, 260, thingsUndone);
		
		
		writer.saveFile();
	}

}
