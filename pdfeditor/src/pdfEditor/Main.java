package pdfeditor;

import java.io.IOException;



public class Main {

	
	
	public static void main(String[] args) throws IOException {
		TextWriter writer = new TextWriter("src/pdfeditor/template.pdf","src/pdfeditor/report.pdf");
		
		writer.openFile();
		
		writer.write(0, 0, "Testing text content writing in PDFbox");
		writer.write(30, 300, "Testing text content writing in PDFbox");
		writer.write(0, 300, "Testing text content aaaa in PDFbox");
		writer.write(0, 200, "Testing text content writing in PDFbox");
		writer.write(200, 0, "Testing text content writing in PDFbox");
		writer.write(400, 400, "TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
		
		
		writer.saveFile();
	}

}
