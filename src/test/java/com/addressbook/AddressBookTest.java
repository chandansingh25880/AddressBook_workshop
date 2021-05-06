package com.addressbook;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddressBookTest {

    @Test
    public void givenContact_WhenAddedToAddressBook_ShouldReturnTrue(){
        AddressBook addressBook = new AddressBook();
        Contact contact = new Contact("chandan","Singh","millingtonia","Lko","up",226001,8887719063L,
                                     "chandan.1sep@gmail.com");
        boolean result = addressBook.addContact(contact);
        Assertions.assertTrue(result);

    }
}

