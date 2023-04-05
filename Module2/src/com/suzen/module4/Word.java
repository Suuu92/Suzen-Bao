package com.suzen.module4;

import java.util.HashSet;
import java.util.Objects;

public class Word {
    public static HashSet<String> words = new HashSet<>();

    public static String uniqueWords(String word) {
        //Lower case all the words and replace punctuation marks (including 's) with nothing
        word = word.toLowerCase().replace(".", "").replace(",", "").replace("?", "").replace(";", "").replace(":", "").replace("\"", "").
                replace("(", "").replace(")", "").replace("!", "").replace("\n", "").replace("\r", "").replace("\t", "").replace("'s", "");
        //Deal with the special cases
        if (word.charAt(word.length() - 1) == '-') {
            word = word.substring(0, word.length() - 1);
        }
        else if (word.charAt(word.length() - 1) == '\'') {
            word = word.substring(0, word.length() - 1);
        }
        else if (word.charAt(0) == '\'') {
            word = word.substring(1);
        }
        addWords(word);
        return word;
    }

    public static void addWords(String word){
        //Add the word into the hashset (no duplicates)
        words.add(word);
    }

    public static void countWords() {
        //The number of unique words is the size of the hashset
        System.out.println(words.size());
    }

    @Override
    public String toString() {
        return "Word{" +
                words +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word)) return false;
        Word word = (Word) o;
        return Objects.equals(words, word.words);
    }

    @Override
    public int hashCode() {
        return words.hashCode();
    }
}
