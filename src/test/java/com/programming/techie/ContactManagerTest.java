package com.programming.techie;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ContactManagerTest {

    ContactManager contactManager;

    @BeforeAll
    public  void setupAll() {
        System.out.println("Should print Before All Tests");
    }

    @BeforeEach
    public void setup() {

        contactManager = new ContactManager();

    }

    @Test
    public void shouldCreateContact() {


        contactManager.addContact("John" , "Doe" , "0123456789");
        Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
        Assertions.assertEquals(1, contactManager.getAllContacts().size());

    }

    @Test
    @DisplayName("Should Not Create Contact When First Name is Null")
    public void shouldThrowRuntimeExceptionWhenFirstNameIsNull() {

        Assertions.assertThrows(RuntimeException.class , () -> {
            contactManager.addContact(null , "Doe" , "0123456789");
        });
    }


    @Test
    @DisplayName("Should Not Create Contact When First Name is Null")
    public void shouldThrowRuntimeExceptionWhenLastNameIsNull() {

        Assertions.assertThrows(RuntimeException.class , () -> {
            contactManager.addContact("John" , null , "0123456789");
        });
    }


    @Test
    @DisplayName("Should Not Create Contact When Phone Number is Null")
    public void shouldThrowRuntimeExceptionWhenPhoneNumberIsNull() {

        Assertions.assertThrows(RuntimeException.class , () -> {
            contactManager.addContact(null , "Doe" , null);
        });
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Should Execute After Each Test");
    }

    @AfterAll
    public  void tearDownAll() {
        System.out.println("Should be executed at the end of the Test");
    }

}