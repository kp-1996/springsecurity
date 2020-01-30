package com.jwtautho.springsecurity.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.assertj.core.util.Lists;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwtautho.springsecurity.util.Contact;


@RestController
@RequestMapping(value = "/contacts/")
public class ContactController {
	Contact contacts = new Contact();

    @GetMapping
    public String getdetails() {
        return contacts.getName();
    }

    @PostMapping
    public void addContact(@RequestBody Contact contact) {
        contacts.setName(contact.getName());
    }
}