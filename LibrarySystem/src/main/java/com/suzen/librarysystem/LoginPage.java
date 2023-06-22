package com.suzen.librarysystem;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.suzen.librarysystem.Main.*;

public class LoginPage {
    public TextField textID;
    public TextField textPIN;
    public Button closeButton;
    // Initiate id
    int id = 0;

    // Use the unique id and pin to log in
    public void login() throws SQLException {
        DatabaseHandler handler = DatabaseHandler.getHandler();
        // Get the entered id and pin from the user
        int enteredID = Integer.parseInt(textID.getText());
        int enteredPin = Integer.parseInt(textPIN.getText());
        // Check if the entered id and pin match each other
        String qu = "SELECT * FROM USERS WHERE PIN = " + enteredPin;
        ResultSet rs = handler.execQuery(qu);
        while(rs.next()) {
            id = rs.getInt("ID");
        }
        // If the user info is correct, close the login window and open the library window
        if (id == enteredID) {
            // Once logged in, set the user entered ID as current user ID
            currentUserID = enteredID;
            closeAndOpenWindow("booksWindow.fxml", "Library");
        } else {
            System.out.println("User info is incorrect, please try again.");
        }

        // Clear the fields
        textID.clear();
        textPIN.clear();
    }

    private void closeAndOpenWindow(String location, String title) {
        try {
            // Open a new window
            Parent parent = FXMLLoader.load(getClass().getResource(location));
            Stage stage2 = new Stage(StageStyle.DECORATED);
            stage2.setTitle(title);
            stage2.setScene(new Scene(parent));
            stage2.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Close the current window
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}