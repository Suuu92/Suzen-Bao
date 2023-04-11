package com.suzen.module5;

import java.util.Objects;

public class CaesarCipher {
    String message;

    public CaesarCipher(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static String encrypt(String string, int shift) {
        //Change the message to a character array
        //Create a shifted string array
        char[] chars = string.toCharArray();
        String[] shifted = new String [string.length()];

        for (int i = 0; i < chars.length; i++) {
            //Use the character's value to shift it to another character by adding the number of shift
            //If value exceeds 'z', use modulus to get back to 'a'
            if (chars[i] + shift > 122) {
                shifted[i] = Character.toString((char) ((chars[i] + shift) % 122 + 96));
            }
            else {
                shifted[i] = Character.toString((char) (chars[i] + shift));
            }
        }

        //Change the result string array back to a string
        StringBuilder result1 = new StringBuilder();
        for (String a: shifted){
            result1.append(a);
        }
        return result1.toString();
    }

    public static String decrypt(String string, int shift) {
        //Change the message to a character array
        //Create a shifted string array

        char[] chars = string.toCharArray();
        String[] shifted = new String [string.length()];

        for (int i = 0; i < chars.length; i++) {
            //Use the character's value to shift it to another character by subtracting the number of shift
            //If value is below 'a', add the total number of letters (26) to get the final value
            if (chars[i] - shift < 97) {
                shifted[i] = Character.toString((char) ((chars[i] - shift) + 26));
            }
            else {
                shifted[i] = Character.toString((char) (chars[i] - shift));
            }
        }

        //Change the result string array back to a string
        StringBuilder result1 = new StringBuilder();
        for (String a: shifted){
            result1.append(a);
        }
        return result1.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CaesarCipher)) return false;
        CaesarCipher that = (CaesarCipher) o;
        return Objects.equals(getMessage(), that.getMessage());
    }

    @Override
    public int hashCode() {
        return message.hashCode();
    }

    @Override
    public String toString() {
        return message;
    }
}
