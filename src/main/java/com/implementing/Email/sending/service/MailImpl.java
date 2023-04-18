package com.implementing.Email.sending.service;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.implementing.Email.sending.entity.Mail;
import com.implementing.Email.sending.repository.MailRepository;

@Service
public class MailImpl implements MailInterface {

	@Autowired
	private MailRepository mailrepository;

	
	@Override
	public Mail saveMail(Mail mail) throws MessagingException{
		 //try {
	    	  
	            // Creating a simple mail message
	            SimpleMailMessage mailMessage
	                = new SimpleMailMessage();
	 
	            // Setting up necessary details
	            mailMessage.setFrom(sender);
	            mailMessage.setTo(mail.getEmailid());
	            mailMessage.setText(mail.getBody());
	            mailMessage.setSubject(mail.getSubject());
	 
	            // Sending the mail
	            javaMailSender.send(mailMessage);
	            System.out.println("Mail Sent Successfully...");
	 //       }
	 
	        // Catch block to handle the exceptions
//	        catch (Exception e) {
//	            System.out.println("Error while Sending Mail");
//	        }
		return mailrepository.save(mail);
	}

	@Override
	public List<Mail> fetchMailEntity() {
		
		return (List<Mail>) mailrepository.findAll();
	}

	@Override
	public Mail fetchMailById(int id) {
		
		return mailrepository.findById(id).get();
	}

	@Override
	public void deleteMailById(int id) {
		mailrepository.deleteById(id);
		
	}

	@Override
	public Mail updateMail(int id, Mail mail) {
		Mail maildb = mailrepository.findById(id).get();
		
		if(Objects.nonNull(mail.getEmailid()) && !"".equalsIgnoreCase(mail.getEmailid())) {
			maildb.setEmailid(mail.getEmailid());
		}
	
		 if(Objects.nonNull(mail.getName()) && !"".equalsIgnoreCase(mail.getName())) {
			maildb.setName(mail.getName());
		}

		if(Objects.nonNull(mail.getSubject()) && !"".equalsIgnoreCase(mail.getSubject())) {
			maildb.setSubject(mail.getSubject());
		}
		
		if(Objects.nonNull(mail.getBody()) && !"".equalsIgnoreCase(mail.getBody())) {
			maildb.setBody(mail.getBody());
		}
//		if(Objects.nonNull(mail.getDate()) && !"".equalsIgnoreCase(mail.getDate())) {
//			maildb.setDate(mail.getDate());
//		}

		return mailrepository.save(maildb);
	}

	@Override
	public Mail fetchMailByEmailId(String emailid) {
		return mailrepository.findByemailidIgnoreCase(emailid);
	}

	@Override
	public Mail fetchMailByDate(Date date) {
		
		return mailrepository.findBydate(date);
	}


    @Autowired private JavaMailSender javaMailSender;
 
    @Value("${spring.mail.username}") private String sender;
	
//	@Override
//	public String sendSimpleMail(Mail mail) throws MessagingException  {
//		
//	      try {
//	    	  
//	            // Creating a simple mail message
//	            SimpleMailMessage mailMessage
//	                = new SimpleMailMessage();
//	 
//	            // Setting up necessary details
//	            mailMessage.setFrom(sender);
//	            mailMessage.setTo(mail.getEmailid());
//	            mailMessage.setText(mail.getBody());
//	            mailMessage.setSubject(mail.getSubject());
//	 
//	            // Sending the mail
//	            javaMailSender.send(mailMessage);
//	            return "Mail Sent Successfully...";
//	        }
//	 
//	        // Catch block to handle the exceptions
//	        catch (Exception e) {
//	            return "Error while Sending Mail";
//	        }
	    }
	
	
	


