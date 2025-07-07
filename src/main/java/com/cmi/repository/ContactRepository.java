package com.cmi.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.cmi.model.Contact;


public interface ContactRepository extends JpaRepository<Contact, Long> {
 boolean existsByEmailId(String emailId);
}
