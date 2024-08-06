package pdfeditor;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;

public class Main {

	public static void main(String[] args) throws IOException {
		File template = new File("src/pdfeditor/template.pdf");
		PDDocument document = PDDocument.load(template);
		document.getEncryption();
		System.out.print("Number of pages: " + document.getNumberOfPages());
		document.close();
	}

}
