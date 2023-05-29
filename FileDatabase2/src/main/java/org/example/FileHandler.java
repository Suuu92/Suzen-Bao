package org.example;

import java.io.File;
import java.util.Objects;

public class FileHandler {
    public static void readFiles(File directory) {
        for (File file: Objects.requireNonNull(directory.listFiles())) {
            if (!file.isDirectory()) {
                // Get the information of each file
                String name = file.getName();
                String path = file.getAbsolutePath();
                String extension = name.substring(name.lastIndexOf(".") + 1);
                long size = file.length();
                // Add the file to the table
                Main.addFile(name, path, extension, Long.toString(size));
            } else {
                readFiles(file);
            }
        }
    }
}
