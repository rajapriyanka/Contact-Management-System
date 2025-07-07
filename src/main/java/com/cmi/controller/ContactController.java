package com.cmi.controller;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cmi.model.Contact;
import com.cmi.service.ContactService;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
@CrossOrigin("*")
public class ContactController {

 @Autowired
 private ContactService service;

 @PostMapping
 public ResponseEntity<Contact> createContact(@Valid @RequestBody Contact contact) {
     return ResponseEntity.ok(service.create(contact));
 }

 @GetMapping
 public ResponseEntity<List<Contact>> getAllContacts() {
     return ResponseEntity.ok(service.getAll());
 }

 @GetMapping("/{id}")
 public ResponseEntity<Contact> getContact(@PathVariable Long id) {
     return service.getById(id)
             .map(ResponseEntity::ok)
             .orElse(ResponseEntity.notFound().build());
 }

 @PutMapping("/{id}")
 public ResponseEntity<Contact> updateContact(@PathVariable Long id, @Valid @RequestBody Contact contact) {
     return ResponseEntity.ok(service.update(id, contact));
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
     service.delete(id);
     return ResponseEntity.noContent().build();
 }
}

