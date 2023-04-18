package com.implementing.Email.sending.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mail {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String emailid;
	private String name;
	private String body;
	private String subject;
	private Date date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Mail(int id, String emailid,  String body, String subject) {
		super();
		this.id = id;
		this.emailid = emailid;
		this.name = name;
		this.body = body;
		this.subject = subject;
		this.date = date;
	}
	public Mail() {
		super();
	}
	@Override
	public String toString() {
		return "Mail [id=" + id + ", emailid=" + emailid + ", body=" + body + ", subject=" + subject
				+  "]";
	}
}
