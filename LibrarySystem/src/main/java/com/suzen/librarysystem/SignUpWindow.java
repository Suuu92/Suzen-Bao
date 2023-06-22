package com.suzen.librarysystem;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.suzen.librarysystem.Main.handler;

public class SignUpWindow {
    // 3 fields for the user to fill in (id is auto generated)
    public TextField textFirstName;
    public TextField textLastName;
    public TextField textPinNum;

    public void createUser(ActionEvent actionEvent) throws SQLException {
        // Create a new user
        String firstName = textFirstName.getText();
        String lastName = textLastName.getText();
        int pin = Integer.parseInt(textPinNum.getText());
        // Initiate user ID
        int id = 0;
        User user = new User(firstName, lastName, pin);
        // Add the user to the database table
        User.addUser(user);

        // Display the user info by popping up an alert
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("User information:");
        // Get the unique user id from the table
        String qu = "SELECT * FROM USERS WHERE PIN = " + pin;
        ResultSet rs = handler.execQuery(qu);
        while(rs.next()) {
            id = rs.getInt("ID");
        }
        alert.setContentText("ID: " + id + "\n First name: " + firstName
                + "\n Last name: " + lastName + "\n Pin number: " + pin);
        alert.showAndWait();

        // Clear the fields
        textFirstName.clear();
        textLastName.clear();
        textPinNum.clear();
    }
}
