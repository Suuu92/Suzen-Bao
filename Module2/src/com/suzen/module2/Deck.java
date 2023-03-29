package com.suzen.module2;

import java.util.Collections;
import java.util.LinkedList;

public class Deck {
    LinkedList<Card> deck = new LinkedList<>();
    
    //Create a deck of 52 cards
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

    //Create a copy of the deck and poll a hand of 7 cards
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Deck)) return false;
        Deck deck1 = (Deck) o;
        return Objects.equals(getDeck(), deck1.getDeck()) && Objects.equals(getHand(), deck1.getHand());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDeck(), getHand());
    }

    @Override
    public String toString() {
        return "Deck{" +
                "deck= " + deck +
                ", hand= " + hand +
                '}';
    }
}
