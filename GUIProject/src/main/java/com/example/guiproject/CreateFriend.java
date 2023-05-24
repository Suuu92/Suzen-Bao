package com.example.guiproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CreateFriend {
    private static String name;
    private static int age;
    private static int contact;
    private static FileReader fr;
    private static BufferedReader br;
    private static ArrayList<Friend> friends = new ArrayList<>();

    // Create a friend in the text file
    public static ArrayList createAllFriends(String fileName) throws IOException {
        fr = new FileReader(fileName);
        br = new BufferedReader(fr);
        String line;
        String friendString = "";
        while ((line = br.readLine()) != null) {
            if (!line.equals(";")) {
                friendString += line;
            }
            else {
                parseFriend(friendString);
                friendString = "";
            }
        }
        return friends;
    }

    // Create a peer friend in the text file
    public static ArrayList createPeerFriends(String fileName) throws IOException {
        fr = new FileReader(fileName);
        br = new BufferedReader(fr);
        String line;
        String friendString = "";
        while ((line = br.readLine()) != null) {
            if (!line.equals(";")) {
                friendString += line;
            }
            else {
                parseFriend(friendString);
                friendString = "";
            }
        }
        return friends;
    }

    // Create a work friend in the text file
    public static ArrayList createWorkFriends(String fileName) throws IOException {
        fr = new FileReader(fileName);
        br = new BufferedReader(fr);
        String line;
        String friendString = "";
        while ((line = br.readLine()) != null) {
            if (!line.equals(";")) {
                friendString += line;
            }
            else {
                parseFriend(friendString);
                friendString = "";
            }
        }
        return friends;
    }

    // How the friend's info is displayed in the friends' book
    private static void parseFriend (String string) {
        int pos = 0;
        int posTwo = 0;
        String name = "";
        int age = 0;
        int contact = 0;
        // Separate name and age
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ',') {
                pos = i;
                name = string.substring(0, pos);
                break;
            }
        }
        // Separate age and contact
        for (int j = 0; j < string.substring(pos+1).length(); j++) {
            if (string.substring(pos+1).charAt(j) == ',') {
                posTwo = pos + j;
                age = Integer.parseInt(string.substring(pos+1, posTwo+1));
                contact = Integer.parseInt(string.substring(posTwo+2));
            }
        }
        friends.add(new Friend(name, age, contact));
    }
}
