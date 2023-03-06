package com.suzen.module4;

public class Circle extends TwoDShape {
    public final double PI = Math.PI;
    private double radius;

    Circle(double radius, Colour colour) {
        this.radius = radius;
        this.colour = colour;
    }

    /** Area of a circle
     * See https://www.cuemath.com/geometry/area-of-a-circle/
     * @return the area of a circle derived from its radius, requiring radius > 0
     */
    public double getArea() {
        return PI * Math.pow(radius, 2);
    }

    @Override
    public String toString() {
        return "Circle {" +
                "area= " + getArea() +
                " color= " + getColour() +
                '}';
    }
}
