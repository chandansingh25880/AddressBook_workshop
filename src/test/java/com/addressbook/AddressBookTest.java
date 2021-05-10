package com.addressbook;

import jdk.internal.icu.text.UnicodeSet;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

import static java.awt.Event.HOME;

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

    @Test
    public void givenListOfContacts_whenSearchByCity_ShouldReturnTrue() {
        AddressBook addressBook = new AddressBook();
        List<Contact> contactDataList = new ArrayList<>();
        contactDataList.add(new Contact("chandan", "singh", "millingonia", "lko",
                "Up", 226001, 8887719063l, "chandan.1sep@gmail.com"));
        contactDataList.add(new Contact("siddhant", "singh", "golfcity", "lko",
                "Up", 226001, 9654981412l, "sid888gmail.com"));
        contactDataList.add(new Contact("Laxman", "singh", "V.D marg", "Lko",
                "Up", 226001, 9658981413l, "laxman@gmail.com"));
        HashMap<String, List<Contact>> contactList = addressBook.addContactList("Family", contactDataList);
        Assertions.assertNotEquals(3, contactList.get("Family").size());
    }
    @Test
    public void givenListOfContacts_whenSearchByCity_ShouldReturnTrue() {
        AddressBook addressBook = new AddressBook();
        List<Contact> contactDataList = new ArrayList<>();
        contactDataList.searchPersonByCity(new Contact("chandan", "Singh", "millingtonia", "lko",
                "Up", 223223, 9654981413l, "chadan.1sep@gmail.com"));
        HashMap<String, List<Contact>> contactList = addressBook.addContactList("Family", contactDataList);
        Assertions.assertEquals(1, contactList.get("Family").size());
    }
    @Test
    public void givenListOfContacts_whenSearchByState_ShouldReturnTrue() {
        AddressBook addressBook = new AddressBook();
        List<Contact> contactDataList = new ArrayList<>();
        contactDataList.searchPersonByState(new Contact("Laxman", "Singh", "V.d marg", "lko",
                "Up", 223223, 9654981413l, "Laxman@gmail.com"));
        HashMap<String, List<Contact>> contactList = addressBook.addContactList("Family", contactDataList);
        Assertions.assertEquals(1, contactList.get("Family").size());
    }
    @Test
    public void givenPathWhenCheckedThenConfirm() throws IOException {
        System.out.println(HOME);
        Path homePath = Paths.get(HOME);
        Assertions.assertTrue(Files.exists(homePath));
        Path path = Paths.get(HOME + "/" + checkContact);
        if (Files.exists(path)) Files.delete(path);
        Assertions.assertTrue(Files.notExists(path));
        Files.createDirectories(path);
        Assertions.assertTrue(Files.exists(path));
        IntStream.range(1, 10).forEach(cntr -> {
            Path tempFile = Paths.get(path + "/temp" + cntr);
            Assertions.assertTrue(Files.notExists(tempFile));
            try {
                Files.createFile(tempFile);
            } catch (IOException e) {
            }
            Assertions.assertTrue(Files.exists(tempFile));
        });

        Files.list(path).filter(Files::isRegularFile).forEach(System.out::println);
        Files.newDirectoryStream(path).forEach(System.out::println);
        Files.newDirectoryStream(path, path1 -> path.toFile().isFile() && path.toString().startsWith("temp")).forEach(System.out::println);
    }

    @Test
    public void givenThreeContactsInDB_WhenRetrieved_ShouldMatchEmployeeCount() {
        AddressBookList addressBookList = new AddressBookList();
        addressBookContactList = addressBookList.readAddressBookData(AddressBookList.IOService.DB_IO);
        Assertions.assertEquals(3, addressBookContactList.size());
    }
}




