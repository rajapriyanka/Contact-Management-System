package com.cmi.controller;

import com.cmi.model.Contact;
import com.cmi.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contacts")
public class ContactViewController {

    @Autowired
    private ContactService service;

    @GetMapping
    public String listContacts(Model model) {
        model.addAttribute("contacts", service.getAll());
        return "contacts";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "add_edit_contact";
    }

    @PostMapping("/save")
    public String saveContact(@Valid @ModelAttribute Contact contact, BindingResult result) {
        if (result.hasErrors()) return "add_edit_contact";

        if (contact.getId() != null) {
            service.update(contact.getId(), contact);
        } else {
            service.create(contact);
        }
        return "redirect:/contacts";
    }

    @GetMapping("/edit/{id}")
    public String editContact(@PathVariable Long id, Model model) {
        Contact contact = service.getById(id).orElseThrow(() -> new IllegalArgumentException("Invalid ID"));
        model.addAttribute("contact", contact);
        return "add_edit_contact";
    }

    @GetMapping("/delete/{id}")
    public String deleteContact(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/contacts";
    }
}
