package com.implementing.Email.sending.repository;

import java.sql.Date;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.implementing.Email.sending.entity.Mail;

@Repository
public interface MailRepository extends CrudRepository<Mail,Integer>{

	public Mail findByemailidIgnoreCase(String emailid);
	
	public Mail findBydate(Date date);
}

