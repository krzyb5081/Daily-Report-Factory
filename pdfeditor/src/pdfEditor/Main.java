package pdfeditor;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class Main {

	public static void main(String[] args) throws IOException {
		File template = new File("src/pdfeditor/template.pdf");
		PDDocument document = PDDocument.load(template);
		
		PDFTextStripper stripper = new PDFTextStripper();
		
		
		
		System.out.print(stripper.getText(document).toString());
		document.close();
	}

}
