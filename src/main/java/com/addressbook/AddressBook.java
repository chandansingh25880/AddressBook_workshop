package com.addressbook;

import java.util.ArrayList;
import java.util.List;

/* @Description - To create a contacts in address book with first name, last name, address, city, state,
 * zip,mobile number.*/
public class AddressBook {
    public static void main(String[] args) {
        System.out.println("Welcome to address book system program");
        Contact contact = new Contact("chandan", "singh", "millingTonia",
                "Lko", "up", 226001,
                9180256231L, "chandan.1sep@gmail.com");
        System.out.println(contact.toString());
        System.out.println("Welcome to the addressbook prog");
    }

    /* @Description - Add new contacts to the address book  */
    public boolean addContact(Contact contact){
        System.out.println(contact);
        List<Contact> contactList = new ArrayList<>();
        try {
            contactList.add(contact);
            System.out.println(contactList);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}


