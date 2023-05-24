package com.example.guiproject;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    public TextField textGetName;
    public Label welcomeText;
    public TextField textGetAge;
    public TextField textGetContact;
    public ListView<Friend> friendList = new ListView<>();
    public Label lblContact;
    public Label lblAge;
    public Label lblName;
    public Button btnGetFriend;
    public Button btnSaveFriend;
    public Button btnLoadFriend;
    public Button btnLoadPeers;
    public Button btnLoadWork;

    // After entering a friend's info, add the friend into the list
    public void addFriend(ActionEvent actionEvent) {
        friendList.getItems().clear();
        String name = textGetName.getText();
        String age = textGetAge.getText();
        String contact = textGetContact.getText();
        Friend temp = new Friend(name, Integer.parseInt(age), Integer.parseInt(contact));
        friendList.getItems().add(temp);
        textGetName.clear();
        textGetAge.clear();
        textGetContact.clear();
    }

    // Display the chosen friend's name, age, and contact
    public void displayFriend(MouseEvent mouseEvent) {
        Friend temp;
        temp = friendList.getSelectionModel().getSelectedItem();
        lblAge.setText(Integer.toString(temp.getAge()));
        lblName.setText(temp.name);
        lblContact.setText(Integer.toString(temp.getContact()));
    }

    // Save the new friend to the text file(s)
    public void saveFriend(ActionEvent actionEvent) throws IOException {
        ObservableList<Friend> myList = friendList.getItems();
        for (Friend f : myList) {
            f.writeToFile();
            if (f.compareFriends(f) == true) {
                f.writeToFileTwo();
            }
            else if (f.compareFriends(f) == false) {
                f.writeToFileThree();
            }
        }
        // Clear the list to avoid duplication
        friendList.getItems().clear();
    }

    // Load all the friends' info
    public void loadFriend(ActionEvent actionEvent) throws IOException {
        friendList.getItems().clear();
        ArrayList<Friend> friends = CreateFriend.createAllFriends("friends.txt");
        for (Friend f : friends) {
            friendList.getItems().add(f);
        }
        friends.clear();
    }

    // Load all the peer friends
    public void loadPeers(ActionEvent actionEvent) throws IOException {
        friendList.getItems().clear();
        ArrayList<Friend> friends = CreateFriend.createPeerFriends("peerFriends.txt");
        for (Friend f : friends) {
            if (f.compareFriends(f) == true) {
                friendList.getItems().add(f);
            }
        }
        friends.clear();
    }

    // Load all the work friends
    public void loadWork(ActionEvent actionEvent) throws IOException {
        friendList.getItems().clear();
        ArrayList<Friend> friends = CreateFriend.createWorkFriends("workFriends.txt");
        for (Friend f : friends) {
            if (f.compareFriends(f) == false) {
                friendList.getItems().add(f);
            }
        }
        friends.clear();
    }
}
