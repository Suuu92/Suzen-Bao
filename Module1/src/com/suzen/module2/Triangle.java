package com.suzen.module2;

public class Triangle extends TwoDShape {
    double side1;
    double side2;
    double side3;

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
}
