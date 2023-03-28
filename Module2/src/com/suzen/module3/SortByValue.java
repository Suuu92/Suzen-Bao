package com.suzen.module3;

import java.util.Comparator;

public class SortByValue implements Comparator<Card> {
    @Override
    public int compare(Card c1, Card c2) {
        if(c1.getValue() > c2.getValue()) {
            return 1;
        }
        else if (c1.getValue() < c2.getValue()) {
            return -1;
        }
        return 0;
    }
}
