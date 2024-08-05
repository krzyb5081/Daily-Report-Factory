package com.editor;

import java.io.IOException;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;

public class Main {

	public static void main(String[] args) throws IOException{
		System.out.print("hello");
	    PdfReader reader = new PdfReader("src/main/resources/template.pdf");
	    PdfWriter writer = new PdfWriter("src/main/resources/template-modified.pdf");
	    PdfDocument pdfDocument = new PdfDocument(reader, writer);
	    pdfDocument.open();
	    pdfDocument.close();

	}

}
