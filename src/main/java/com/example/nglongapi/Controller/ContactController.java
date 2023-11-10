package com.example.nglongapi.Controller;

import com.example.nglongapi.Model.Contact;
import com.example.nglongapi.Repository.ContactRepository;
import com.example.nglongapi.Services.ContactServices;
import com.example.nglongapi.helper.LienHeDto;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*")
public class ContactController {
    @Autowired
    ContactServices contactServices;
    ContactRepository contactRepository;
    Gson gson = new Gson();
    @GetMapping(value = "getallcontact")
    private List<Contact> layTatCaLienHe(){
        return contactServices.getAllContact();
    }
    @PostMapping(value = "putnewcontact")
    private Contact themMotLienHe(@RequestBody String contact){
        System.out.println(contact);
       Contact a  =gson.fromJson(contact,Contact.class);
        return contactServices.addNewContact(a);
    }
    @DeleteMapping(value = "deletecontact/{id}")
    private Contact xoaMotLienHe(@PathVariable int id){
        return contactServices.deleteContact(id);
    }
    @PutMapping(value = "postcontact")
    private Contact capnhattt(@RequestBody String contact) {
        Contact contact1 = gson.fromJson(contact,Contact.class);
        return contactServices.updateContact(contact1);
    }
}
