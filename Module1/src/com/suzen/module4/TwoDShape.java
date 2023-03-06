package com.suzen.module4;

abstract class TwoDShape {
    double width;
    double height;
    Colour colour;

    public TwoDShape(double width, double height, Colour colour){
        this.width = width;
        this.height = height;
        this.colour = colour;
    }

    public TwoDShape(){

    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    // Get area from Circle and Triangle subclasses
    abstract double getArea();

    @Override
    public String toString() {
        return "TwoDShape";
    }
}
