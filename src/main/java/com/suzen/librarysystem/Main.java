package com.suzen.librarysystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static DatabaseHandler handler;
    // Once logged in, the current user ID will be used to access the database
    public static int currentUserID;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("mainWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Library Database!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        handler = DatabaseHandler.getHandler();
        launch();
    }
}