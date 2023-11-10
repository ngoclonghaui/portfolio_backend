package com.example.nglongapi.Services;

import com.example.nglongapi.Model.Contact;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IContact {
    public List<Contact> getAllContact();
    public Contact updateContact(Contact contact);
    public Contact deleteContact(int id);
    public Contact addNewContact(Contact contact);
}
