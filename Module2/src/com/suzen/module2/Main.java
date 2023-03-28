package com.suzen.module2;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        //Shuffle the deck of 52 cards
        deck.shuffle();
        System.out.println("Deck of cards: " + deck.getDeck());

        //Poll a hand of 7 cards (first one in is the last one out)
        deck.drawHand();
        System.out.println("Hand of cards: " + deck.getHand());
    }
}
