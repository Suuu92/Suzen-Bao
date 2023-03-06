package com.suzen.module3;

abstract class TwoDShape {
    double width;
    double height;

    public TwoDShape(double width, double height){
        this.width = width;
        this.height = height;
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

    abstract double getArea();

    @Override
    public String toString() {
        return "TwoDShape";
    }
}
