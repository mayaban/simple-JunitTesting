package org.example;

import org.junit.jupiter.api.*;

import java.time.Clock;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ContactManagerTest {
    private ContactManager contactManager;

    @BeforeAll
    public  void setUpAll(){
        System.out.println("Should execute Before all tests");
    }

    @BeforeEach
    public void setUp(){
        contactManager=new ContactManager();
    }

    @AfterEach
    public void tearDown(){
        System.out.println("Should execute after each test");
    }

    @AfterAll
    public  void tearDownAll(){
        System.out.println("Should execute after all the tests");
    }

    @Test
    @DisplayName("Should create contact")
    public void shouldCreateContact(){
       // ContactManager contactManager=new ContactManager();
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

    @Test
    @DisplayName("Should not create contact if the firstName is null")
    public void shouldThrowRuntimeExceptionWhenFirstNameIsNull(){
        Assertions.assertThrows(RuntimeException.class,()->{
            contactManager.addContact(null,"Thapa","9849801073");
        });
    }

    @Test
    @DisplayName("Should not create contact if the lastName is null ")
    public void shouldThrowRuntimeExceptionWhenLastnameIsNull(){
        Assertions.assertThrows(RuntimeException.class,()->{
            contactManager.addContact("Ram",null,"9849801073");
        });
    }

    @Test
    @DisplayName("Should not create contact if the phone number is null ")
    public void shouldThrowRuntimeExceptionWhenPhoneNumberIsNull(){
        Assertions.assertThrows(RuntimeException.class,()->{
            contactManager.addContact("Ram","Thapa",null);
        });
    }


}