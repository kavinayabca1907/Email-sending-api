package com.implementing.Email.sending.service;

import java.sql.Date;
import java.util.List;

import javax.mail.MessagingException;

import com.implementing.Email.sending.entity.Mail;

public interface MailInterface {

	public Mail saveMail(Mail mail) throws MessagingException;

	public List<Mail> fetchMailEntity();

	public Mail fetchMailById(int id);

	public void deleteMailById(int id);

	public Mail updateMail(int id, Mail mail);

	public Mail fetchMailByEmailId(String emailid);

	public Mail fetchMailByDate(Date date);

	//public String sendSimpleMail(Mail mail) throws MessagingException ;

}
