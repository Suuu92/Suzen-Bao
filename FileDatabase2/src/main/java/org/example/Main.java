package org.example;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static DatabaseHandler handler;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 1 to create a new table | Enter 2 to retrieve your files:");
        if (scanner.nextLine().equals("1")) {
            // Take in the directory
            System.out.println("Enter the directory:");
            String direcPath = scanner.nextLine();
            File directory = new File(direcPath);
            // Name the table with the name of the directory
            DatabaseHandler.name = directory.getName();
            handler = DatabaseHandler.getHandler();
            FileHandler.readFiles(directory);
        } else {
            System.out.println("Enter the directory name to retrieve files:");
            String direcName = scanner.nextLine();
            handler = DatabaseHandler.getHandler();
            retrieveFile(direcName);
        }
    }

    public static void addFile(String name, String path, String extension, String size) {
        // Add in each file as an entry to a new table
        String st = "INSERT INTO " + DatabaseHandler.name + " (file_name, path, extension, size_in_bytes) VALUES (" +
                "'" + name + "'," +
                "'" + path + "'," +
                "'" + extension + "'," +
                "'" + size + "')";
        handler.execAction(st);
    }

    public static void retrieveFile(String table) {
        // Retrieve every file and sub file within the given directory
        ResultSet rs = handler.execQuery("SELECT * FROM " + table);
        try {
            while (rs.next()) {
                String name = rs.getString("FILE_NAME");
                String path = rs.getString("PATH");
                String extension = rs.getString("EXTENSION");
                String size = rs.getString("SIZE_IN_BYTES");
                // Display the files from the given directory
                System.out.println("File name: " + name + "\n" + "Path: " + path + "\n"
                        + "Extension: " + extension + "\n" + "Size in bytes: " + size);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}