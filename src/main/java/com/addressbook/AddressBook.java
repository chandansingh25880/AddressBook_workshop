package com.addressbook;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.*;
import java.util.stream.IntStream;


/* @Description - To create a contacts in address book with first name, last name, address, city, state,
 * zip,mobile number.*/
public class AddressBook {
    private static AddressBook addressBook;
    private List<Contact> contact;

    public static AddressBook getInstance() {
        if (addressBook == null)
            addressBook = new AddressBook();
        return addressBook;
    }

    private Connection getConnection() throws SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3306/address_book?useSSL=false";
        String userName = "root";
        String password = "root";
        Connection connection;
        System.out.println("Connecting to database:" + jdbcURL);
        connection = DriverManager.getConnection(jdbcURL, userName, password);
        System.out.println("Connection is successful!" + connection);
        return connection;
    }

    public List<Contact> getAddressBookDataUsingDB() {
        String sql = "SELECT * FROM address_book";
        List<Contact> contact = new ArrayList<>();
        try (Connection connection = this.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            contact = getAddressBookDataList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contact;
    }

    private List<Contact> getAddressBookDataList(ResultSet resultSet) {
        List<Contact> contacts = new ArrayList<>();
        try {
            while (resultSet.next()) {
                String firstName = resultSet.getString("firstname");
                String lastName = resultSet.getString("lastname");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                int zip = resultSet.getInt("zip");
                long mobileNumber = resultSet.getLong("mobileNumber");
                String emailId = resultSet.getString("emailId");
                contacts.add(new Contact(firstName, lastName, address, city, state, zip, mobileNumber, emailId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contact;
    }
}
 




   





