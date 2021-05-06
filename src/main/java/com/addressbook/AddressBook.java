package com.addressbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* @Description - To create a contacts in address book with first name, last name, address, city, state,
 * zip,mobile number.*/
public class AddressBook {
    public static List<Contact> contactList = new ArrayList<>();
    public static HashMap<String, List<Contact>> addressBookMap = new HashMap<>();


    public static void main(String[] args) {
        System.out.println("Welcome to address book system program");
        Contact contact = new Contact("chandan", "singh", "millingTonia",
                "Lko", "up", 226001,
                9180256231L, "chandan.1sep@gmail.com");
        System.out.println(contact.toString());
        System.out.println("Welcome to the addressbook prog");
    }

    /* @Description - Add new contacts to the address book  */
    public HashMap<String, List<Contact>> addContact(String addressBookName, Contact contact) {
        try {
            if (!addressBookMap.containsKey(addressBookName)) createNewAddAddressBook(addressBookName);
            addressBookMap.get(addressBookName).add(contact);
            System.out.println("Contact Added Successfully.");
        } catch (Exception e) {
            System.out.println("Contact not added " + e);
            e.printStackTrace();
        }
        return addressBookMap;
    }


    /* @Description - To use the edit contact person using their name.*/

    public Object editContact(HashMap<String, List<Contact>> addressBookList, String addressBookName, String name, String fieldName, String update) {
        try {
            if (addressBookList.containsKey(addressBookName)) {
                List<Contact> contactList = addressBookList.get(addressBookName);
                for (Contact contact : contactList) {
                    if (contact.firstName.equals(name)) {
                        switch (fieldName) {
                            case "firstName":
                                contact.firstName = update;
                                break;
                            case "lastName":
                                contact.lastName = update;
                                break;
                            case "address":
                                contact.address = update;
                                break;
                            case "city":
                                contact.city = update;
                                break;
                            case "state":
                                contact.state = update;
                                break;
                            case "zip":
                                contact.zip = Integer.parseInt(update);
                                break;
                            case "phone":
                                contact.phoneNumber = Long.parseLong(update);
                                break;
                            case "email":
                                contact.emailId = update;
                                break;
                        }
                        System.out.println("Contact updated with name : " + name);
                    }
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Details not matching " + e);
            e.printStackTrace();
        }
        return false;
    }


    public boolean deleteContact(HashMap<String, List<Contact>> addressBookList, String addressBookName, String name) {
        try {
            if (addressBookList.containsKey(addressBookName)) {
                List<Contact> contactList = addressBookList.get(addressBookName);
                for (Contact contact : contactList) {
                    if (contact.firstName.equals(name)) {
                        contactList.remove(contactList.indexOf(contact));
                        System.out.println("Contact deleted with name : " + name);
                        break;
                    }
                }
            }
            return true;
        } catch (Exception e) {
            System.out.println("Name not found :" + e);
            e.printStackTrace();
        }
        return false;
    }

    /* @Description - Add multiple contact in address book .
     * @Return- contact list */
    public List<Contact> addMultipleContactList(List<Contact> contactDataList) {
        public List<Contact> addMultipleContactList(List <Contact> contactDataList){
            try {
                for (Contact contact : contactDataList) {
                    addContact(contact);
                }
                return contactList;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return contactList;
        }
    }

   





