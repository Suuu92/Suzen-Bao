package com.suzen.librarysystem;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MainWindow {
    // Pop up the signup window when clicking "Sign up" button
    public void signUpWindow() {
        loadWindow("signUpWindow.fxml", "Sign Up Page");
    }

    // Pop up the login window when clicking "Log in" button
    public void loginWindow() {
        loadWindow("loginPage.fxml", "Login Page");
    }

    // Open a new window
    private void loadWindow(String location, String title) {
        try{
            Parent parent = FXMLLoader.load(getClass().getResource(location));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle(title);
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}