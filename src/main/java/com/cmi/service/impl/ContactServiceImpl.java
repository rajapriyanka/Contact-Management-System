package com.cmi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmi.model.Contact;
import com.cmi.repository.ContactRepository;
import com.cmi.service.ContactService;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

 @Autowired
 private ContactRepository repository;

 @Override
 public Contact create(Contact contact) {
     if (repository.existsByEmailId(contact.getEmailId())) {
         throw new IllegalArgumentException("Duplicate Email");
     }
     return repository.save(contact);
 }

 @Override
 public List<Contact> getAll() {
     return repository.findAll();
 }

 @Override
 public Optional<Contact> getById(Long id) {
     return repository.findById(id);
 }

 @Override
 public Contact update(Long id, Contact updatedContact) {
     Contact contact = repository.findById(id)
             .orElseThrow(() -> new RuntimeException("Contact not found"));
     contact.setFirstName(updatedContact.getFirstName());
     contact.setLastName(updatedContact.getLastName());
     contact.setAddress(updatedContact.getAddress());
     contact.setEmailId(updatedContact.getEmailId());
     contact.setPhoneNumber(updatedContact.getPhoneNumber());
     return repository.save(contact);
 }

 @Override
 public void delete(Long id) {
     repository.deleteById(id);
 }
}
