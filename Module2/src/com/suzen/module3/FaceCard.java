package com.suzen.module3;

public class FaceCard extends Card {
    private String faceName;

    public FaceCard(int value, Suit suit, String faceName) {
        super(value, suit);
        if (value == 11) {
            this.faceName = "Jack";
        }
        else if (value == 12) {
            this.faceName = "Queen";
        }
        else if (value == 13) {
            this.faceName = "King";
        }
        else{
            this.faceName = Integer.toString(value);
        }
    }

    public String getFaceName() {
        return faceName;
    }

    public void setFaceName(String faceName) {
        this.faceName = faceName;
    }

    @Override
    public String toString() {
        return "FaceCard{" +
                "Suit= '" + getSuit() + '\'' +
                "Value='" + faceName + '\'' +
                '}';
    }
}
