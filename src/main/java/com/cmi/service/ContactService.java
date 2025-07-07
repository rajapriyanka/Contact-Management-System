package com.cmi.service;

import java.util.List;
import java.util.Optional;

import com.cmi.model.Contact;

public interface ContactService {
 Contact create(Contact contact);
 List<Contact> getAll();
 Optional<Contact> getById(Long id);
 Contact update(Long id, Contact updatedContact);
 void delete(Long id);
}
