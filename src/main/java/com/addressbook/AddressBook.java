package com.addressbook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.IntStream;


/* @Description - To create a contacts in address book with first name, last name, address, city, state,
 * zip,mobile number.*/
public class AddressBook {
    public static List<Contact> contactList = new ArrayList<>();
    public static HashMap<String, List<Contact>> addressBookMap = new HashMap<>();
    private HashMap<Object, Object> contact;

    /* @Description - to write the employee contacts details */

    private static void writeEmployeeContactsData(Scanner consoleInputReader) {
        System.out.println("Enter your first name");
        String firstName = consoleInputReader.nextLine();
        System.out.println("Enter your last name");
        String lastName = consoleInputReader.nextLine();
        System.out.println("Enter your address name");
        String address = consoleInputReader.nextLine();
        System.out.println("Enter your city name");
        String city = consoleInputReader.nextLine();
        System.out.println("Enter your state name");
        String state = consoleInputReader.nextLine();
        System.out.println("Enter your zip  code ");
        int  zip = consoleInputReader.nextInt();
        System.out.println("Enter your zip  code ");
        long  phoneNumber = consoleInputReader.nextLong();
        System.out.println("Enter your email Id");
        String emailId = consoleInputReader.nextLine();

    }

    /* @Description - to read  the employee contacts details */
    private static void readEmployeeContactsData() {
        System.out.println("Write employee contacts details " + employeeContactsList);
    }



    public static void main(String[] args) {
        System.out.println("Welcome to address book system program");
        Scanner consoleInputReader = new Scanner(System.in);
        AddressBook.writeEmployeeContactsData(consoleInputReader);
        AddressBook.readEmployeeContactsData();
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
        public List<Contact> addMultipleContactList (List < Contact > contactDataList) {
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
        /* @Description - Add multiple contact in address book to the system
         *  each address book has a unique name.
         * @Return- addressbookmap */

        public HashMap<String, List<Contact>> createNewAddAddressBook (String addressBookName){
            try {
                addressBookMap.put(addressBookName, new ArrayList<Contact>());
                System.out.println("New Address Book Created with Name : " + addressBookName);
            } catch (Exception e) {
                System.out.println("Invalid name" + e);
                e.printStackTrace();
            }
            return addressBookMap;
        }
    }

    /* Description - to view person by city  */
    public void viewPersonByCity() {
        System.out.println("Enter the city to search person.");
        String cityName = sc.next();
        System.out.println("Person Search by " + cityName);
        Collection<Contact> values = contact.values();
        ArrayList<Contact> conatactlist
                = new ArrayList<>(values);
        Dictionary dictWithCity = new Hashtable();
        conatactlist.stream().filter(n -> n.city.contains(cityName)).forEach(contactlist -> dictWithCity.put(contactlist.firstName, cityName));
        for (Enumeration i = dictWithCity.keys(); i.hasMoreElements(); ) {
            System.out.println(i.nextElement());
        }
    }

    /* Description - to view person by state  */

    public void viewPersonByState() {
        System.out.println("Enter the state to search person.");
        String stateName = sc.next();
        System.out.println("Person Search by " + stateName);
        Collection<Contact> values = contact.values();
        ArrayList<Contact> conatactlist
                = new ArrayList<>(values);
        Dictionary dictWithState = new Hashtable();
        conatactlist.stream().filter(n -> n.state.contains(stateName)).forEach(contactlist -> dictWithState.put(contactlist.firstName, stateName));
        for (Enumeration i = dictWithState.keys(); i.hasMoreElements(); ) {
            System.out.println(i.nextElement());
        }
    }




   





