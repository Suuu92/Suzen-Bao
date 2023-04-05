package com.suzen.module4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //Add each line as an element to an arraylist
        ArrayList<String> lines = new ArrayList<>();
        ArrayList<String> wordsTemp = new ArrayList<>();
        Scanner scanner = new Scanner(new File("illiad.txt"));
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            lines.add(line);
        }

        //Split the text into individual words
        for (int i = 0; i < lines.size(); i++) {
            String[] word = lines.get(i).split(" ");
            for (int j = 0; j < word.length; j++) {
                if (word[j].length() > 0) {
                    wordsTemp.add(word[j]);
                }
           }
        }

        for (int i = 0; i < wordsTemp.size(); i++) {
            //Convert all the words and add unique ones into the hashset
            Word.uniqueWords(wordsTemp.get(i));
        }

        //Count the number of unique words in the text
        Word.countWords();
    }
}
