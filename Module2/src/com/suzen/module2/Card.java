package com.suzen.module2;

public class Card {
    private int value;
    private Suit suit;

    public Card(int value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return getValue() == card.getValue() && getSuit() == card.getSuit();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue(), getSuit());
    }

    @Override
    public String toString() {
        return "{value=" + value +
                ", suit=" + suit + "}";
    }
}
