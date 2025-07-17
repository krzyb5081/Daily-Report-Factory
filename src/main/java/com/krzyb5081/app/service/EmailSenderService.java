package com.krzyb5081.app.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailSenderService {
	@Autowired
    private JavaMailSender mailSender;
	
	private File report;
	
	public EmailSenderService(){
		this.report = new File("src/main/resources/generator/report.pdf");
	}
	public EmailSenderService(File reportFile){
		this.report = reportFile;
	}
	
	

    public void sendEmailWithAttachment(String toEmail,
                                        String subject,
                                        String body,
                                        String attachmentPath) throws MessagingException {

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(toEmail);
        helper.setSubject(subject);
        helper.setText(body);
        helper.setFrom("email@gmail.com");

        FileSystemResource file = new FileSystemResource(new File(attachmentPath));
        helper.addAttachment(file.getFilename(), file);

        mailSender.send(message);
    }
}
