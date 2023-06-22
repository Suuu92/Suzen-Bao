package com.suzen.librarysystem;

public class User {
    // User information (3 fields)
    String firstName;
    String lastName;
    int pinNum;

    public static DatabaseHandler handler;

    // Create a new user object
    User (String firstName, String lastName, int pinNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pinNum = pinNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPinNum() {
        return pinNum;
    }

    // Add the user's info to the database table
    public static void addUser(User user) {
        handler = DatabaseHandler.getHandler();
        String qu = "INSERT INTO USERS (first_name, last_name, pin) VALUES (" +
                "'" + user.firstName + "'," +
                "'" + user.lastName + "'," +
                user.pinNum + ")";
        handler.execAction(qu);
        System.out.println("User is created");
    }
}
