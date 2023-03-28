package com.suzen.module2;

import java.util.Collections;
import java.util.LinkedList;

public class Deck {
    LinkedList<Card> deck = new LinkedList<>();

    public Deck() {
        for(int i = 1; i < 14; i++) {
            deck.add(new Card(i, Suit.CLUBS));
        }
        for (int i = 1; i < 14; i++) {
            deck.add(new Card(i, Suit.HEARTS));
        }
        for (int i = 1; i < 14; i++) {
            deck.add(new Card(i, Suit.DIAMONDS));
        }
        for (int i = 1; i < 14; i++) {
            deck.add(new Card(i, Suit.SPADES));
        }
        this.deck = deck;
    }

    public void shuffle() {
        Collections.shuffle(deck);
        this.deck = deck;
    }

    public LinkedList<Card> getDeck() {
        return deck;
    }

    LinkedList<Card> hand = new LinkedList<>(deck);
    public void drawHand() {
        for (int i = 0; i < 7; i++) {
            hand.add(deck.pollLast());
        }
        this.hand = hand;
    }

    public LinkedList<Card> getHand() {
        return hand;
    }

    @Override
    public String toString() {
        return "Deck{" +
                "deck= " + deck +
                ", hand= " + hand +
                '}';
    }
}
