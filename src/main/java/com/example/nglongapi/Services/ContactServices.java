package com.example.nglongapi.Services;

import com.example.nglongapi.Model.Contact;
import com.example.nglongapi.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServices implements IContact{
    @Autowired
    ContactRepository contactRepository;
    @Override
    public List<Contact> getAllContact() {
        return contactRepository.findAll();
    }

    @Override
    public Contact updateContact(Contact contact) {
        Optional<Contact> contact1 = contactRepository.findById(contact.getId());
        if(contact1.isEmpty()){
            return null;
        }
        contact1.get().setId(contact.getId());
        contact1.get().setTenLienHe(contact.getTenLienHe());
        contact1.get().setEmail(contact.getEmail());
        contact1.get().setMessage(contact.getMessage());
        contactRepository.save(contact1.get());
        return contact1.get();
    }

    @Override
    public Contact deleteContact(int id) {
        Optional<Contact> contact = contactRepository.findById(id);
        if(contact.isEmpty()){
            return null;
        }
        contactRepository.delete(contact.get());
        return contact.get();
    }

    @Override
    public Contact addNewContact(Contact contact) {
        contactRepository.save(contact);
        return contact;
    }
}
