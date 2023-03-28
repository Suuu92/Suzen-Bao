package com.suzen.module3;

public class NumberCard extends Card {

    public NumberCard(int value, Suit suit) {
        super(value, suit);
    }

    @Override
    public String toString() {
        return "NumberCard{}" +
                "Suit= '" + getSuit() + '\'' +
                "Value='" + getValue() + '\'' +
                '}';
    }

}
