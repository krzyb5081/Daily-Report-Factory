package pdfeditor;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class Main {

	public static void main(String[] args) throws IOException {
		File template = new File("src/pdfeditor/template.pdf");
		
		//loading document
		PDDocument document = PDDocument.load(template);
		
		//getting first page
		PDPage page = document.getPage(0);
		
		//preparing content stream for editing in append mode
		PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, false);
		
		//starting text content
		contentStream.beginText();
		
		//setting text position
		contentStream.newLineAtOffset(0, 0);
		
		//setting font
		contentStream.setFont(PDType1Font.TIMES_BOLD_ITALIC, 14);
		
		//write text content
		contentStream.showText("Testing text content writing in PDFbox");
		
		//ending text content
		contentStream.endText();
		
		//closing content stream
		contentStream.close();
		
		//saving document
		document.save("src/pdfeditor/report.pdf");
		
		//closing document
		document.close();
	}

}
