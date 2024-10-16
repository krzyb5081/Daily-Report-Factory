package pdfeditor;

import java.io.IOException;



public class Main {

	
	
	public static void main(String[] args) throws IOException {
		TextWriter writer = new TextWriter("src/pdfeditor/template.pdf","src/pdfeditor/report.pdf");
		
		writer.openFile();
		
		writer.write(20, 20, "TTTTTTTTTTTTT TTTTTTTTTTTTTTTTTTTTTTTTTT ");
		
		
		writer.saveFile();
	}

}
