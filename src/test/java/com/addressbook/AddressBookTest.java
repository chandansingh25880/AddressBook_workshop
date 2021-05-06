package com.addressbook;

import jdk.internal.icu.text.UnicodeSet;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AddressBookTest {

    private AddressBook addressBook;
    private Contact contact;

    @Before
    public void initialize() {
        AddressBook addressBook;
    }

    @Test
    public void givenContact_WhenAddedToAddressBook_ShouldReturnTrue() {
        AddressBook addressBook = new AddressBook();
        Contact contact = new Contact("chandan", "Singh", "millingtonia", "Lko", "up", 226001, 8887719063L,
                "chandan.1sep@gmail.com");
        HashMap<String, List<Contact>> contactList = addressBook.addContact("Family", contact);
        Assertions.assertEquals(1, contactList.get("Family").size());
    }

    @Test
    public void givenContactName_whenEdit_ShouldReturntrue() {
        Contact contacts = new Contact("Chandan", "Singh",
                "millingtonia", "lko", "Up", 223223, 8887719063L, "chandan.1sep@gmail.com");
        boolean result = addressBook.addContact(contact);
        HashMap<String, List<Contact>> contactList = addressBook.addContact("Family", contacts);
        boolean result = addressBook.editContact(contactList, "Family", "chadan", "address", "millingtonia");
    }

    @Test
    public void givenContactName_whenEdit_ifNotMatching_ShouldReturnfalse() {
        Contact contact = new Contact("Chandan", "Singh",
                "millingtonia", "lko", "Up", 226001, 8887719063L, "chadan.1sep@gmail.com");
        boolean result = addressBook.addContact(contact);
        HashMap<String, List<Contact>> contactList = addressBook.addContact("Family", contact);
        boolean result = addressBook.editContact(contactList, "Family", "chand", "address", "millingtonia");
    }

    @Test
    public void givenContactName_whenDeleted_ShouldReturnTrue() {
        AddressBook addressBook = new AddressBook();
        Contact contact = new Contact("chandan", "singh", "millingtonia", "lko", "up", 226001, 8887719063L,
                "amarprajapati99@gmail.com");
        HashMap<String, List<Contact>> contactList = addressBook.addContact("Family", contact);
        boolean result = addressBook.deleteContact(contactList, "Family", "chandan");
        Assertions.assertEquals(1, deleteContactList.size());
    }

    @Test
    public void givenContactName_whenNotDeleted_ShouldReturnFalse() {
        AddressBook addressBook = new AddressBook();
        Contact contact = new Contact("chandan", "singh", "millingtonia", "lko", "up", 226001, 8887719063L,
                "chandan.1sep@gmail.com");
        HashMap<String, List<Contact>> contactList = addressBook.addContact("Family", contact);
        boolean result = addressBook.deleteContact(contactList, "Family", "chandan");
        Assertions.assertEquals(1, deleteContactList.size());
    }

    @Test
    public void givenListOfContact_whenAddedMultipleContact_ShouldReturnTrue() {
        AddressBook addressBook = new AddressBook();
        List<Contact> contactDataList = new ArrayList<>();
        contactDataList.add(new Contact("Laxman", "Singh", "V.D marg", "lko",
                "Up", 226001, 9621005291l, "Laxman2@gmail.com"));
        contactDataList.add(new Contact("Siddhant", "Singh", "GolfCity", "Lko",
                "Up", 223223, 962323413l, "sid8888@gmail.com"));
        HashMap<String, List<Contact>> contactList = addressBook.addContactList("Family", contactDataList);
        Assertions.assertEquals(3, contactList.get("Family").size());
    }

    @Test
    public void givenListOfContacts_whenDuplicateContact_ShouldPassTheTest() {
        AddressBook addressBook = new AddressBook();
        List<Contact> contactDataList = new ArrayList<>();
        contactDataList.add(new Contact("chandan", "Singh", "millingtonia", "lko",
                "Up", 226001, 8887719063l, "chandan.1sep@gmail.com"));
        contactDataList.add(new Contact("Laxman", "Laxman", "V.D marg", "lko",
                "Up", 226001, 8887719063l, "laxman@gmail.com"));
        HashMap<String, List<Contact>> contactList = addressBook.addContactList("Family", contactDataList);
        Assertions.assertNotEquals(3, contactList.get("Family").size());
    }
    @Test
    public void givenListOfContacts_whenDuplicateContact_ShouldReturnFalse() {
        AddressBook addressBook = new AddressBook();
        List<Contact> contactDataList = new ArrayList<>();
        contactDataList.add(new Contact("chandan", "Singh", "millingtonia", "lko",
                "Up", 226001, 8887719063l, "chandan.1sep@gmail.com"));
        contactDataList.add(new Contact("Siddhant", "Singh", "GolfCity", "Lko",
                "Up", 223223, 9654981413l, "sid888@gmail.com"));
        HashMap<String, List<Contact>> contactList = addressBook.addContactList("Family", contactDataList);
        Assertions.assertNotEquals(3, contactList.get("Family").size());

    }
}


