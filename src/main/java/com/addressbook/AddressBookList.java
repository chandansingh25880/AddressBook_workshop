package com.addressbook;

import java.util.List;

public class AddressBookList {
    private List<Contact> addressBookList;

    public enum IOService {
        DB_IO
    }

    private List<Contact> contacts;
    public AddressBook addressBook;

    public AddressBookList() {
        addressBook = AddressBook.getInstance();
    }

    public AddressBookList(List<Contact> addressBook) {
        this();
        this.addressBookList = addressBook;
    }

    public List<Contact> readAddressBookData(IOService ioService) {
        if (ioService.equals(IOService.DB_IO))
            return this.addressBookList = addressBook.getAddressBookDataUsingDB();
        return null;
    }
}

