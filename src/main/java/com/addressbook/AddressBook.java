package com.addressbook;

import java.util.ArrayList;
import java.util.List;

/* @Description - To create a contacts in address book with first name, last name, address, city, state,
 * zip,mobile number.*/
public class AddressBook {
    public List<Contact> contactList;

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

    /* @Description - To use the edit contact person using their name.*/

    public Contact editContact(List<Contact> contactList, String name, String fieldName, String edit) {
        try {
            for(Contact contact : contactList){
                if(contact.firstName.equals(name)) {
                    switch (fieldName) {
                        case "firstName":
                            contact.firstName = edit;
                            break;
                        case "lastName":
                            contact.lastName = edit;
                            break;
                        case "address":
                            contact.address = edit;
                            break;
                        case "city":
                            contact.city = edit;
                            break;
                        case "state":
                            contact.state = edit;
                            break;
                        case "zip":
                            contact.zip = Integer.parseInt(edit);
                            break;
                        case "phone":
                            contact.phoneNumber = Long.parseLong(edit);
                            break;
                        case "email":
                            contact.emailId = edit;
                            break;
                    }
                }
                return contact;
            }
        } catch (Exception e) {
            System.out.println("Details not matching " + e);
            e.printStackTrace();
        }
        return null;
    }
}



