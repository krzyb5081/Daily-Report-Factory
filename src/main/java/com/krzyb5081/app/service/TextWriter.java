package com.krzyb5081.app.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

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
		InputStream fontStream = getClass().getResourceAsStream("/fonts/Anonymous_Pro.ttf");
		PDType0Font font = PDType0Font.load(document, fontStream);
		this.contentStream.setFont(font, 14);
		
		//setting initial text position
		this.contentStream.newLineAtOffset(offsetX, offsetY);
		
		for(String textFragment: this.splitText(text, 100)) {
			
			//write text content
			this.contentStream.showText(textFragment);
			
			//setting new line position
			this.contentStream.newLineAtOffset(0, -20);
			
		}
		
		//ending text content
		this.contentStream.endText();
		
		//closing content stream
		this.contentStream.close();
	}
	
	public void openFile() {
		//loading document
		try {
			this.document = PDDocument.load(templateFile);
		} catch (IOException e) {
			this.document = new PDDocument();
		
			//getting first page
			this.page = new PDPage();
			this.document.addPage(page);
		}
		
	}
	
	public File saveFile() throws IOException {
		//saving document
		this.document.save(outputFile);
		
		//closing document
		this.document.close();
		
		return outputFile;
		
	}
	
	private List<String> splitText(String text, int maxLineLength) {
		List<String> textList = new ArrayList<String>();
		
		if(text.length() <= maxLineLength) {
			textList.add(text);
			return textList;
		}
		
		int startIndex = 0;
		
		while(startIndex < text.length()) {
			
			
			int endIndex = startIndex + maxLineLength;
			
			if(endIndex >= text.length()) {
				endIndex = text.length();
			} else {
				while((endIndex < text.length() && (text.charAt(endIndex) != ' '))) endIndex++;
				
			}
			
			textList.add(text.substring(startIndex, endIndex));
			
			startIndex = endIndex;
			
		}
		
		
		for (String showString: textList) {
			System.out.println(showString);
		}
		
		return textList;
	}
}