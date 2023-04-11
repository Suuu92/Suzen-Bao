package com.suzen.module5;

import java.util.HashMap;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        //Create 2 hashmaps that encrypts/ decrypts the given message
        HashMap<CaesarCipher, CaesarCipher> encryptMap = new HashMap<> ();
        HashMap<CaesarCipher, CaesarCipher> decryptMap = new HashMap<> ();

        //Input some messages for testing
        //E.g. expected: u -> w, v -> x, w -> y, x -> z, y -> a (go back to a), z -> b
        encryptMap.put(new CaesarCipher("uvwxyz"), new CaesarCipher(CaesarCipher.encrypt("uvwxyz", 2)));
        encryptMap.put(new CaesarCipher("abcdefghi"), new CaesarCipher(CaesarCipher.encrypt("abcdefghi", 25)));
        encryptMap.put(new CaesarCipher("programming"), new CaesarCipher(CaesarCipher.encrypt("programming", 15)));

        decryptMap.put(new CaesarCipher("cdefgh"), new CaesarCipher(CaesarCipher.decrypt("cdefgh", 19)));
        decryptMap.put(new CaesarCipher("jgnnq"), new CaesarCipher(CaesarCipher.decrypt("jgnnq", 2)));
        decryptMap.put(new CaesarCipher("egdvgpbbxcv"), new CaesarCipher(CaesarCipher.decrypt("egdvgpbbxcv", 15)));

        Iterator<CaesarCipher> Iterator1 = encryptMap.keySet().iterator();
        Iterator<CaesarCipher> Iterator2 = decryptMap.keySet().iterator();

        System.out.println("****** Encrypted Message ******");
        while (Iterator1.hasNext()) {
            CaesarCipher c = Iterator1.next();
            System.out.println("Your message: " + c + ", Encrypted message: " + encryptMap.get(c));
        }

        System.out.println(" ");
        System.out.println("****** Decrypted Message ******");
        while (Iterator2.hasNext()) {
            CaesarCipher c = Iterator2.next();
            System.out.println("Your message: " + c + ", Decrypted message: " + decryptMap.get(c));
        }
    }
}
