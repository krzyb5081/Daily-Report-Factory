package pdfeditor;

import java.io.IOException;



public class Main {

	
	
	public static void main(String[] args) throws IOException {
		TextWriter writer = new TextWriter("src/pdfeditor/template.pdf","src/pdfeditor/report.pdf");
		
		writer.openFile();
		
		writer.write(120, 700, "TEXT 1");
		writer.write(300, 700, "TEXT 2");
		writer.write(400, 700, "TEXT 3");
		writer.write(120, 600, "TEXT 4");
		writer.write(120, 420, "TEXT 5");
		writer.write(120, 260, "TEXT 6");
		
		
		writer.saveFile();
	}

}
