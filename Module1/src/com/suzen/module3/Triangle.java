package com.suzen.module3;

public class Triangle extends TwoDShape implements Rotate{
    double side1;
    double side2;
    double side3;
    double angle;

    public Triangle(double width, double height) {
        super(width, height);
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.height = heronsHeight();
    }

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
