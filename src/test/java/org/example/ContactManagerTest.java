package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Clock;
import java.util.Arrays;
import java.util.List;

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

    @Test
    @DisplayName("Should create only on MacOs ")
    @EnabledOnOs(value= OS.MAC,disabledReason = "Only on Windows os")
    public void shouldThrowRuntimeExceptionWhenPhoneNumberIsNullMacOs(){
        Assertions.assertThrows(RuntimeException.class,()->{
            contactManager.addContact("Ram","Thapa",null);
        });
    }

    @RepeatedTest(value=5,name="Testing on repeat {currentRepetition} of {totalRepetitions}" )
    @DisplayName("Should test for repetitive test")
    public void shouldThrowRuntimeExceptionWhenPhoneNumberIsNullRepeatedTest(){
        Assertions.assertThrows(RuntimeException.class,()->{
            contactManager.addContact("Ram","Thapa",null);
        });
    }

    @ParameterizedTest
    @DisplayName("Examples of Parameterised testing ")
    @ValueSource(strings ={"9849801073","9876510234","+9889013462"})
    public void shouldCreateContactParameterisedTest(String phoneNumber){
        // ContactManager contactManager=new ContactManager();
        contactManager.addContact("Ram","Thapa",phoneNumber);
        Assertions.assertFalse(contactManager.getAllContact().isEmpty());
        Assertions.assertEquals(1,contactManager.getAllContact().size());
       /* Assertions.assertTrue(contactManager.getAllContact().stream()
                .filter(contact -> contact.getFirstName().equals("Ram") &&
                        contact.getLastName().equals("Thapa") &&
                        contact.getPhoneNumber().equals("9849801073"))
                .findAny()
                .isPresent());*/


    }

    @ParameterizedTest
    @DisplayName("Examples of Parameterised testing ")
    @MethodSource("phoneNumberList")
    public void shouldCreateContactParameterisedTestMethodSource(String phoneNumber) {
        // ContactManager contactManager=new ContactManager();
        contactManager.addContact("Ram", "Thapa", phoneNumber);
        Assertions.assertFalse(contactManager.getAllContact().isEmpty());
        Assertions.assertEquals(1, contactManager.getAllContact().size());
    }

    @ParameterizedTest
    @DisplayName("Examples of Parameterised testing ")
    @CsvSource({"9849801073","9876510234","+9889013462"})
    public void shouldCreateContactParameterisedTestCsvSource(String phoneNumber) {
        // ContactManager contactManager=new ContactManager();
        contactManager.addContact("Ram", "Thapa", phoneNumber);
        Assertions.assertFalse(contactManager.getAllContact().isEmpty());
        Assertions.assertEquals(1, contactManager.getAllContact().size());
    }

    @ParameterizedTest
    @DisplayName("Examples of Parameterised testing ")
    @CsvFileSource(resources = "/data.csv")
    public void shouldCreateContactParameterisedTestCsvFileSource(String phoneNumber) {
        // ContactManager contactManager=new ContactManager();
        contactManager.addContact("Ram", "Thapa", phoneNumber);
        Assertions.assertFalse(contactManager.getAllContact().isEmpty());
        Assertions.assertEquals(1, contactManager.getAllContact().size());
    }

    public static List<String> phoneNumberList(){
        return Arrays.asList("9849801073","9876510234","+9889013462");
    }

}