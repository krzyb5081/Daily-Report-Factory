package pdfeditor;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class TextWriter {

	private File templateFile;
	private File outputFile;
	private PDDocument document;
	private PDPage page;
	private PDPageContentStream contentStream;
	
	public TextWriter(String templateFilePath, String outputFilePath) {
		templateFile = new File(templateFilePath);
		outputFile = new File(outputFilePath);
	}
	
	public void write(float offsetX, float offsetY, String text) throws IOException {
		
		
		//preparing content stream for editing in append mode
		this.contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, false);
		
		//starting text content
		this.contentStream.beginText();
		
		//setting font
		this.contentStream.setFont(PDType1Font.TIMES_BOLD_ITALIC, 14);
		
		//setting text position
		this.contentStream.newLineAtOffset(offsetX, offsetY);
		
		//write text content
		this.contentStream.showText(text);
		
		//just for testing
				//setting text position
				this.contentStream.newLineAtOffset(offsetX, offsetY);
				
				//write text content
				this.contentStream.showText(text);
				//setting text position
				this.contentStream.newLineAtOffset(offsetX, offsetY);
				
				//write text content
				this.contentStream.showText(text);
				//setting text position
				this.contentStream.newLineAtOffset(offsetX, offsetY);
				
				//write text content
				this.contentStream.showText(text);
		
		//ending text content
		this.contentStream.endText();
		
		//closing content stream
		this.contentStream.close();
	}
	
	public void openFile() throws IOException {
		//loading document
		this.document = PDDocument.load(this.templateFile);
		
		//getting first page
		this.page = document.getPage(0);
	}
	
	public void saveFile() throws IOException {
		//saving document
		this.document.save(outputFile);
		
		//closing document
		this.document.close();
	}
}
