package com.example.guiproject;

import java.io.*;

public class Friend {
    public String name;
    public int age;
    public int contact;

    // Basic info that need to be entered
    Friend(String name, int age, int contact) {
        this.name = name;
        this.age = age;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getContact() {
        return contact;
    }

    // Save the friends' info to different text files
    public void writeToFile() throws IOException{
        FileWriter fw = new FileWriter("friends.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(name +",\r");
        bw.write(Integer.toString(age) + ",\r");
        bw.write(Integer.toString(contact) + "\r");
        bw.write(";\r");
        bw.close();
    }

    public void writeToFileTwo() throws IOException{
        FileWriter fw = new FileWriter("peerFriends.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(name +",\r");
        bw.write(Integer.toString(age) + ",\r");
        bw.write(Integer.toString(contact) + "\r");
        bw.write(";\r");
        bw.close();
    }

    public void writeToFileThree() throws IOException{
        FileWriter fw = new FileWriter("workFriends.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(name +",\r");
        bw.write(Integer.toString(age) + ",\r");
        bw.write(Integer.toString(contact) + "\r");
        bw.write(";\r");
        bw.close();
    }

    public String toString() {
        return "Name: " + name + "\tAge:  " + age + "\tContact: " + contact;
    }

    // Classify the friend as a peer friend/a work friend based on his/her age
    public boolean compareFriends (Friend f) {
        boolean key = false;
        if (this.age == 16) {
            key = true;
        }
        else if (this.age == 17) {
            key = true;
        }
        else if (this.age == 18) {
            key = true;
        }
        else {
            key = false;
        }
    return key;
    }
}
