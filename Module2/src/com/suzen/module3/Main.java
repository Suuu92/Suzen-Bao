package com.suzen.module3;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        //Shuffle the deck of 52 cards
        deck.shuffle();
        System.out.println("Deck of cards: " + deck.getDeck());

        //Poll a hand of 7 cards (first one in is the last one out)
        deck.drawHand();
        System.out.println("Hand of cards: " + deck.getHand());

        //Create an identical deck for sorting
        Deck deck2 = new Deck();
        LinkedList<Card> cards = new LinkedList<>();
        for (int i = 0; i < deck2.getDeck().size(); i++) {
            cards.add(deck2.getDeck().get(i));
        }

        //Sort by ascending value
        SortByValue v = new SortByValue();
        Collections.sort(cards, v);
        Iterator<Card> iterator = cards.iterator();
        System.out.println(" ");
        System.out.println("******** Sorted by Value **********");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //Sort by Suit (Order: Spades, Hearts, Clubs, Diamonds)
        SortBySuit s = new SortBySuit();
        Collections.sort(cards, s);
        Iterator<Card> iterator2 = cards.iterator();
        System.out.println(" ");
        System.out.println("******** Sorted by Suit **********");
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }
    }
}
