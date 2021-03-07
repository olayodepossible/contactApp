package com.possible.crm.controllers;

import com.possible.crm.model.Contact;
import com.possible.crm.repositories.ContactRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ContactController {
    private ContactRepository contactRepository;

    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @GetMapping("/contacts")
    Collection<Contact> getContacts(){
        return(Collection<Contact>) contactRepository.findAll();
    }

    @PostMapping("/contacts")
    ResponseEntity<Contact> createContact( @RequestBody Contact contact){
        Contact result = contactRepository.save(contact);
        return ResponseEntity.ok(result);
    }
}
