package com.implementing.Email.sending.controller;

import java.sql.Date;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.implementing.Email.sending.entity.Mail;
import com.implementing.Email.sending.service.MailInterface;

@RestController
public class MailController {

	@Autowired
	private MailInterface mailservice;
	
//	@PostMapping("/sendMail")
//	public String sendMail(@RequestBody Mail mail) throws MessagingException  {
//		String status = mailservice.sendSimpleMail(mail);
//		return status;
//		
//	}
	
	@PostMapping("/mails")
	public Mail saveMail(@RequestBody Mail mail) throws MessagingException {
		return mailservice.saveMail(mail);
		
	}
	
	@GetMapping("/mails")
	public List<Mail> fetchMailEntity(){
		return mailservice.fetchMailEntity();
		
	}

	@GetMapping("/mails/{id}")
	public Mail fetchMailById(@PathVariable("id") int id) {
		return mailservice.fetchMailById(id);
	}
	
	@DeleteMapping("/mails/{id}")
	public String deleteMailById(@PathVariable("id")int id) {
		 mailservice.deleteMailById(id);
		return "Mail deleted Successfully!!";
		
	}
	
	@PutMapping("/mails/{id}")
	public Mail updateMail(@PathVariable("id") int id, @RequestBody Mail mail) {
		return mailservice.updateMail(id,mail);
	}
	
	@GetMapping("/mails/emailid/{emailid}")
	public Mail fetchMailByEmailId(@PathVariable("emailid") String emailid) {
		return mailservice.fetchMailByEmailId(emailid);
	}
	@GetMapping("/mails/date/{date}")
	public Mail fetchMailByDate(@PathVariable("date") Date date) {
		return mailservice.fetchMailByDate(date);
	}
	
	
}
