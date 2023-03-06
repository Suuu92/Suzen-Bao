package com.suzen.module1;

public class TwoDShape {
    double width;
    double height;

    public TwoDShape(double width, double height){
        this.width = width;
        this.height = height;
    }

    public TwoDShape(){

    }

    public double getArea() {
        return width * height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
