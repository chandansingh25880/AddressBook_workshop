package com.addressbook;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AddressBookTest {

    private AddressBook addressBook;
    private Contact contact;

    @Before
    public void initialize() {
        AddressBook addressBook;
    }

    @Test
    public void givenContact_WhenAddedToAddressBook_ShouldReturnTrue(){
        AddressBook addressBook = new AddressBook();
        Contact contact = new Contact("chandan","Singh","millingtonia","Lko","up",226001,8887719063L,
                                     "chandan.1sep@gmail.com");
        boolean result = addressBook.addContact(contact);
        Assertions.assertTrue(result);

    }

    @Test
    public void givenContactName_whenEdit_ShouldReturntrue(){
        Contact contacts= new Contact("Chandan", "Singh",
                "millingtonia", "lko", "Up", 223223, 8887719063L, "chandan.1sep@gmail.com");
        boolean result = addressBook.addContact(contact);
        Contact editContact = addressBook.editContact(addressBook.contactList, "chandan", "address","millingtonia");
        Assertions.assertEquals("millingtonia", editContact.address);
    }

    @Test
    public void givenContactName_whenEdit_ifNotMatching_ShouldReturnfalse(){
        Contact contact= new Contact("Chandan", "Singh",
                "millingtonia", "lko", "Up", 226001, 8887719063L, "chadan.1sep@gmail.com");
        boolean result = addressBook.addContact(contact);
        Contact editContact = addressBook.editContact(addressBook.contactList, "Chand", "address","millingtonia");
        Assertions.assertEquals("somapur", editContact.address);
    }
}

