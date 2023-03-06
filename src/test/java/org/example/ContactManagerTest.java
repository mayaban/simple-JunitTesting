package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactManagerTest {

    @Test
    public void shouldCreateContact(){
        ContactManager contactManager=new ContactManager();
        contactManager.addContact("Ram","Thapa","9849801073");
        Assertions.assertFalse(contactManager.getAllContact().isEmpty());
        Assertions.assertEquals(1,contactManager.getAllContact().size());
        Assertions.assertTrue(contactManager.getAllContact().stream()
                .filter(contact -> contact.getFirstName().equals("Ram") &&
                        contact.getLastName().equals("Thapa") &&
                        contact.getPhoneNumber().equals("9849801073"))
                .findAny()
                .isPresent());


    }

}