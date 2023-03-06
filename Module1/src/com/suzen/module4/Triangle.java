package com.suzen.module4;

public class Triangle extends TwoDShape implements Rotate {
    double side1;
    double side2;
    double side3;
    double angle;

    public Triangle(double width, double height, Colour colour) {
        super(width, height, colour);
    }

    public Triangle(double side1, double side2, double side3, Colour colour) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.colour = colour;
        this.height = heronsHeight();
    }

    /** Heron's Formula
     * See https://www.youtube.com/watch?v=a1PR9O1Va84
     * @return the height of a triangle calculated from the Heron's Formula
     */
    private double heronsHeight() {
        if (height != 0) {
            return height;
        }
        else {
            double semiPerimeter = (side1 + side2 + side3) / 2;
            double height = 2 / (side2 * Math.sqrt(semiPerimeter * (semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3)));
            return height;
        }
    }

    /** Area of a triangle
     * Using width and height: see https://www.cuemath.com/measurement/area-of-triangle/
     * Requires height > 0 and width > 0
     * Using 3 sides: see https://www.youtube.com/watch?v=a1PR9O1Va84
     * Special Requirement: the sum of the lengths of any two sides > the length of the third side
     * @return the area of a triangle when different parameters are used
     */
    public double getArea() {
        if (side2 != 0) {
            double semiPerimeter = (side1 + side2 + side3) / 2;
            return Math.sqrt(semiPerimeter * (semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3));
        }
        else {
            return 0.5 * width * height;
        }
    }

    @Override
    public String toString() {
        return "Triangle {" +
                "area= " + getArea() +
                " color= " + getColour() +
                '}';
    }

    @Override
    public void rotate90() {
        System.out.println("Rotate 90 degrees");
    }

    @Override
    public void rotate180() {
        System.out.println("Rotate 180 degrees");
    }

    @Override
    public void rotate(double degree) {
        System.out.println("Rotate " + degree + " degrees");
    }
}
