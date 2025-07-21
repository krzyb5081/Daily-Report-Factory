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
	    List<String> textList = new ArrayList<>();

	    String[] fragments = text.split("\\|");

	    for (String fragment : fragments) {
	        fragment = fragment.trim();

	        if (fragment.length() <= maxLineLength) {
	            textList.add(fragment);
	        } else {
	            int startIndex = 0;

	            while (startIndex < fragment.length()) {
	                int endIndex = startIndex + maxLineLength;

	                if (endIndex >= fragment.length()) {
	                    endIndex = fragment.length();
	                } else {
	                    // don't cut word in half
	                    while (endIndex < fragment.length() && fragment.charAt(endIndex) != ' ') {
	                        endIndex++;
	                    }
	                }

	                String part = fragment.substring(startIndex, endIndex).trim();
	                if (!part.isEmpty()) {
	                    textList.add(part);
	                }

	                startIndex = endIndex;
	            }
	        }
	    }

	    // Debug print
	    for (String s : textList) {
	        System.out.println("[line] " + s);
	    }

	    return textList;
	}
}