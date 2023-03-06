package com.suzen.module4;

public class Main {
    public static void main(String[] args) {
        // Create some objects that need to be included in the list
        Circle c1 = new Circle(2, Colour.NONE);
        Circle c2 = new Circle(6, Colour.GREEN);
        Circle c3 = new Circle(7.2, Colour.RED);
        Circle c4 = new Circle(20.32, Colour.BLUE);

        Triangle t1 = new Triangle(7,9, Colour.RED);
        Triangle t2 = new Triangle(2.1,9.5, Colour.BLUE);
        Triangle t3 = new Triangle(3,4,5, Colour.NONE);
        Triangle t4 = new Triangle(9,10,11, Colour.GREEN);
        Triangle t5 = new Triangle(2.1,3.4,4.8, Colour.NONE);

        // Add both Circles and Triangles into the list
        TwoDShape [] list = {c1, c2, c3, c4, t1, t2, t3, t4, t5};

        /** Circles and Triangles checking list
         * Circles: requiring radius > 0
         * Triangle: requiring side1 + side2 > side3, side1 + side3 > side2, side2 + side3 > side1,
         * side1 > 0, side2 > 0, side3 > 0 OR width > 0, height > 0
         */
        for (int i = 0; i < list.length; i++){
            System.out.println(list[i]);
        }
    }
}
